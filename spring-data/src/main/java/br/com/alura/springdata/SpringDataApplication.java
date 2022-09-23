package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeTrabalhoService;
import br.com.alura.springdata.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	
	//variavel auxiliar para fechar o programa
	private Boolean system = true;

	// esse é o construtor da minha classe SpringDataApplication
	public SpringDataApplication(CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService,
			CrudUnidadeTrabalhoService unidadeTrabalhoService,
			RelatoriosService relatoriosService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(system) {
			System.out.println("QUAL AÇÃO DESEJA EXECUTAR?");
			System.out.println("0 - Para sair do programa.");
			System.out.println("1 - Cargo.");
			System.out.println("2 - Funcionario.");
			System.out.println("3 - Unidade de Trabalho.");
			System.out.println("4 - Relatorios.");
			
			int action = sc.nextInt();
			switch (action) {
			case 1:
				cargoService.inicial(sc);
				break;
			case 2:
				funcionarioService.inicial(sc);
				break;
			case 3:
				unidadeTrabalhoService.inicial(sc);
				break;
			case 4:
				relatoriosService.inicial(sc);
				break;
			default:
				system = false;
				break;
			}
		}
	}
}
