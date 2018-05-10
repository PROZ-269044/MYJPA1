package model;

import java.math.BigDecimal;
import java.util.Date;

public class CRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CRUDWorker CRUDWorker = new CRUDWorker();
		Worker worker = new Worker();
		
		worker.setEmpno(new BigDecimal(4000));
		worker.setEname("ADDAMS");
		worker.setJob("SUPPORT");
		worker.setMgr(new BigDecimal(7369));
		worker.setSal(new BigDecimal(1250));
		worker.setHiredate(new Date());
		worker.setComm(new BigDecimal(4000));
		worker.setDeptno(new BigDecimal(10));
		
		
		
		
		CRUDWorker.createWorker(worker);
		CRUDWorker.readWorker(4000);
		CRUDWorker.updateWorker(4000);
		CRUDWorker.readWorker(4000);
		//CRUDWorker.deleteWorker(4000);

	}

}
