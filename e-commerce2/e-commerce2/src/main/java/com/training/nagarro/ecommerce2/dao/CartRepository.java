package com.training.nagarro.ecommerce2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.nagarro.ecommerce2.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	
	@Query(value="select * from Cart u where u.user_id=:id",nativeQuery=true)
	List<Cart> find(@Param(value="id")long id);

	@Modifying
	@Query(value="delete from Cart u where u.productId=:idproduct")
	void deleteProduct(@Param(value="idproduct")Long idproduct);

	@Modifying
	@Query(value="update Cart u set u.stock = u.stock - :stock1 where u.productId = :id ")
	void upDate(@Param(value="stock1")int stock,@Param(value="id") long id);

	@Modifying
	@Query(value="update Cart u set u.quantity = :qua, u.totalPrice = u.totalPrice * :qua where u.id = :idcart")
	void update(@Param(value="qua")int qua,@Param(value="idcart")long idcart);

	
	@Query(value="select * from Cart u where u.user_id = :iduser and u.stock > 0",nativeQuery=true)
	List<Cart> check(@Param(value="iduser") long iduser);

	@Modifying
	@Query(value="delete from Cart u where u.userId = :iduser")
	void deleteUserId(@Param(value="iduser")long iduser);
	
	@Query(value="select count(*) from Cart u where u.userId = :iduser")
	int getCount(@Param(value="iduser")long iduser);
}
