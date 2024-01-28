package squad25.comercioFacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query
	(nativeQuery = true, value = "SELECT * FROM `user` WHERE email = :email AND `password` = :password")
	Client findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
}