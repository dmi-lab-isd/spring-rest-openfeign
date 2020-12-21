package org.labisd.rpc.dto;

public class SumResult {
	private int sum;
	private String serverId;
	
	@Override
	public String toString() {
		return String.format(
				"ServerInfo[sum=%d, serverId='%s']",
				sum, serverId);
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public int getSum() {
		return sum;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerId() {
		return serverId;
	}
}
