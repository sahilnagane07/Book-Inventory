package org.cap.bim.repository;

import java.util.List;

import org.cap.bim.model.PurchaseLog;
import org.cap.bim.model.PurchaseLogKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseLogRepository extends JpaRepository<PurchaseLog, PurchaseLogKey>{
	
	List<PurchaseLog> findByUserId(Integer userId);
}
