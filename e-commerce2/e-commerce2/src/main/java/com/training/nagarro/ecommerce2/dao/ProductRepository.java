package com.training.nagarro.ecommerce2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.nagarro.ecommerce2.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	@Modifying
	@Query(value="update Product u set u.price = :price,u.discount = :discount,u.stock=:stock  where u.id = :id")
	void updateQuery(@Param(value="stock") int stock,@Param(value = "price") Double double1, @Param(value = "discount") int discount,@Param(value="id") long id);

	@Modifying
	@Query(value="select * from Product u where u.name like %:name%",nativeQuery = true)
	List<Product> getByName(@Param(value="name") String name);

	
	@Query(value="select * from Product u where u.id=:id",nativeQuery=true)
	Product find(@Param(value="id")long id);

	
	@Query(value="select * from Product u where u.vendor_id = :idvendor",nativeQuery=true)
	List<Product> findVendorProduct(@Param(value="idvendor")long idvendor);

	@Modifying
	@Query(value="delete from Product u where u.id=:id")
	void delete(@Param(value="id")long id);

	@Modifying
	@Query(value="update Product u set u.stock = u.stock - :stock1 where u.id = :id ")
	void updateStock(@Param(value="stock1")int stock1,@Param(value="id") long id);

	
	@Query(value="select * from Product u where u.name like %:name% or u.brand like %:name% or u.category like %:name% ;",nativeQuery=true)
	List<Product> searchByKey(@Param(value="name")String name);

	
	@Query(value="select distinct(u.brand) from Product u")
	List<String> brand();
	
	@Query(value="select distinct(u.category) from Product u")
	List<String> category();

	
	@Query(value="select * from Product u where u.brand like %:brand% or u.category like %:category% order by u.brand= :brand desc ;",nativeQuery=true)
	List<Product> search2(@Param(value="brand")String brand,@Param(value="category")String category);
}
