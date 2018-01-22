package br.com.msf.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msf.exception.CalculoTaxaAgendamentoException;
import br.com.msf.mock.AgendamentoMock;
import br.com.msf.model.Agendamento;
import br.com.msf.repository.AgendamentoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendamentoServiceImplTest {

	@Autowired
	AgendamentoServiceImpl agendamentoService;
	
	@Mock
	AgendamentoRepository agendamentoRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		agendamentoService.setAgendamentoRepository(agendamentoRepository);
	}

	@Test
	public void salvarAgendamentoParaOMesmoDia() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoMesmoDia();
		
		// When
		agendamentoService.salvar(agendamento);

		// Then
		assertEquals(3.09, agendamento.getTaxa(), 0.001);
	}
	
	@Test
	public void salvarAgendamentoComIntervaloEntreUmEDezDias() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoIntervaloEntreUmEDezDias();

		// When
		agendamentoService.salvar(agendamento);

		// Then
		assertEquals(60, agendamento.getTaxa(), 0.001);
	}

	@Test
	public void salvarAgendamentoComIntervaloEntreOnzeEVinteDias() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoIntervaloEntreOnzeEVinteDias();

		// When
		agendamentoService.salvar(agendamento);

		// Then
		assertEquals(8, agendamento.getTaxa(), 0.001);
	}
	
	@Test
	public void salvarAgendamentoComIntervaloEntreVinteUmETrintaDias() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoIntervaloEntreVinteUmETrintaDias();

		// When
		agendamentoService.salvar(agendamento);

		// Then
		assertEquals(6, agendamento.getTaxa(), 0.001);
	}

	@Test
	public void salvarAgendamentoComIntervaloEntreTrintaUmEQuarenteDias() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoIntervaloEntreTrintaUmEQuarenteDias();

		// When
		agendamentoService.salvar(agendamento);

		// Then
		assertEquals(4, agendamento.getTaxa(), 0.001);
	}

	@Test
	public void salvarAgendamentoComIntervaloMaiorQuarentaEValorMaiorQueCemMil() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoComIntervaloMaiorQuarentaEValorMaiorQueCemMil();

		// When
		agendamentoService.salvar(agendamento);

		// Then
		assertEquals(2, agendamento.getTaxa(), 0.001);
	}
	
	@Test(expected=CalculoTaxaAgendamentoException.class)
	public void salvarAgendamentoIntervaloNegativo() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoIntervaloNegativo();
		
		// When
		agendamentoService.salvar(agendamento);
	}

	@Test(expected=CalculoTaxaAgendamentoException.class)
	public void salvarAgendamentoIntervaloSemTaxa() throws CalculoTaxaAgendamentoException {
		// Given
		Agendamento agendamento = AgendamentoMock.receberAgendamentoIntervaloSemTaxa();
		
		// When
		agendamentoService.salvar(agendamento);
	}
}