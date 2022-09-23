package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	//variavel auxiliar para fechar o programa
	private Boolean system = true;
	
	private final CrudCargoService cargoService;

	// esse é o construtor da minha classe SpringDataApplication
	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
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
			
			int action = sc.nextInt();
			switch (action) {
			case 1:
				cargoService.inicial(sc);
				break;
			default:
				system = false;
				break;
			}
		}
	}
}
