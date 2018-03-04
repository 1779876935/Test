package com.ssm.entity;

import java.io.Serializable;

public class user implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String EMPNO;
	private String ENAME;
	private String JOB;
	private String MGR;
	private String HIREDATE;
	private String SAL;
	private String COMM;
	private String DEPTNO;
	public String getEMPNO() {
		return EMPNO;
	}
	public void setEMPNO(String eMPNO) {
		EMPNO = eMPNO;
	}
	public String getENAME() {
		return ENAME;
	}
	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public String getMGR() {
		return MGR;
	}
	public void setMGR(String mGR) {
		MGR = mGR;
	}
	public String getHIREDATE() {
		return HIREDATE;
	}
	public void setHIREDATE(String hIREDATE) {
		HIREDATE = hIREDATE;
	}
	public String getSAL() {
		return SAL;
	}
	public void setSAL(String sAL) {
		SAL = sAL;
	}
	public String getCOMM() {
		return COMM;
	}
	public void setCOMM(String cOMM) {
		COMM = cOMM;
	}
	public String getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(String dEPTNO) {
		DEPTNO = dEPTNO;
	}
	
	@Override
	public String toString() {
		return "user [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB + ", MGR=" + MGR + ", HIREDATE=" + HIREDATE
				+ ", SAL=" + SAL + ", COMM=" + COMM + ", DEPTNO=" + DEPTNO + "]";
	}
	
}
