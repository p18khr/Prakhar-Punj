package com.training.nagarro.ecommerce2.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.nagarro.ecommerce2.model.Product;
import com.training.nagarro.ecommerce2.model.SaleReport;
import com.training.nagarro.ecommerce2.model.Sales;

public interface SaleRepository extends JpaRepository<Sales, Long> {

	
	@Query(value="select * from Sales",nativeQuery=true)
	List<Sales> find();

	@Query(value="select * from Sales u where u.user_id= :iduser order by u.id desc limit 1",nativeQuery=true)
	Sales getOrder(@Param(value="iduser")long iduser);

	
	@Query(value="select * from Sales u where u.user_id= :iduser order by u.id desc limit :count",nativeQuery=true)
	List<Sales> getLOrders(@Param(value="iduser")long iduser,@Param(value="count") int count);

	
	@Query(value="select * from Sales u where u.user_id= :iduser order by id desc",nativeQuery=true)
	List<Sales> getOrders(@Param(value="iduser")long iduser);

	
	@Query(value="select * from Sales u where u.vendor_id =:idvendor and u.order_date between :startDate and :endDate",nativeQuery=true)
	List<Sales> filter(@Param(value="startDate")String startDate,@Param(value="endDate")String endDate,@Param(value="idvendor")long idvendor);

	@Query(value="select distinct(u.category) from Sales u")
	List<String> category();

	
	@Query(value="select distinct(u.brand) from Sales u")
	List<String> brand();

	@Query(value="select * from Sales u where u.name like %:name% or u.brand like %:name% or u.category like %:name% ;",nativeQuery=true)
	List<Sales> searchByKey(String name);

	
	@Query(value="select * from Sales u where u.brand like %:brand% and u.category like %:category% ;",nativeQuery=true)
	List<Sales> search2(String brand, String category);

	
	
	
}
