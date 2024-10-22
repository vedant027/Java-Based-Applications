package com.mess.core;

public enum MESSPLAN {
	MONTHLY(3000,1),QUARTERLY(11700,3),HALFYEAR(17500,6),YEARLY(32000,12);
	
	 private int planbill;
	 private int planduration;
	
	 private MESSPLAN(int planbill,int planduration) {
		 this.planbill=planbill;
		 this.planduration=planduration;
	 } 
	 
	public int getPlanbill() {
		return planbill;
	}

	public int getPlanduration() {
		return planduration;
	}
	
	
	 
}
