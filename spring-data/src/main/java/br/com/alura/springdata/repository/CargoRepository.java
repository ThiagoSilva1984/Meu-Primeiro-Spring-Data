package br.com.alura.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Cargo;

@Repository //essa é uma anotação spring que o spring vai ler
public interface CargoRepository extends CrudRepository<Cargo, Integer>{
	/*	ao inves de criar uma classe entityManager, o CrudRepository, já faz isso, trazendo tudo pronto
	 * 
	 */

}
