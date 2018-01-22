package br.com.msf.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msf.Application;
import br.com.msf.exception.CalculoTaxaAgendamentoException;
import br.com.msf.mock.AgendamentoMock;
import br.com.msf.model.Agendamento;
import br.com.msf.repository.AgendamentoRepository;
import br.com.msf.service.AgendamentoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AgendamentoServiceImplTest {

	@Autowired
	AgendamentoService agendamentoService;
	
	AgendamentoRepository agendamentoRepository;
	
	@Before
	public void setup() {
		agendamentoRepository = mock(AgendamentoRepository.class);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(agendamentoRepository);
	}
	
	@Test
	public void salvarAgendamentoParaOMesmoDia() throws CalculoTaxaAgendamentoException {
		Agendamento agendamento = AgendamentoMock.receberAgendamentoMesmoDia();
		agendamentoService.salvar(agendamento);
		System.out.println(agendamento.getTaxa());
		assertEquals(3.09, agendamento.getTaxa());
		
		
	}
}
