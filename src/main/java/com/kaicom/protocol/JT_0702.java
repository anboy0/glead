package com.kaicom.protocol;

public class JT_0702 implements IMessageBody{

    //1 ���� 2 �γ�
    private byte CardState ;
    //�忨��ο�ʱ�� ��״̬Ϊ1ʱ��Ч YYMMDDHHmmss
    private String OperTime ;
    //���������0�ɹ� ����ʧ��
    private byte ReadResult ;
    
    /// ��ʻԱ��������    
    private byte DriverNameLength ;
    
    /// ��ʻԱ����    
    private String DriverName ;
    
    /// ��ҵ�ʸ�֤���� ����20    
    private String CertificationCode ;
    
    /// ��֤�������Ƴ���    
    private byte AgencyNameLength ;
    
    /// ��֤��������    
    private String AgencyName ;
    
    /// ֤����Ч�� YYYYMMDD    
    private String ValidateDate ;
    //2011�ɰ�Э�飬����Ǿɰ�Э�飬�Ͳ��þɵĸ�ʽ
    private JT_0702_old oldDriverData;
    

	@Override
	public String toString()
	{
		if(oldDriverData != null)
			return oldDriverData.toString();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("˾�����ƣ�%1$s,IC��״̬��%2$s,��ҵ�ʸ�֤��%3$s,��֤������%4$s", getDriverName(), this.CardState, getCertificationCode(), getAgencyName()));
		return sBuilder.toString();
	}
    

	public final byte[] WriteToBytes()
	{
		return null;
	}
	 

	public final void ReadFromBytes(byte[] bytes)
	{
		if(bytes.length > 62)
		{
			oldDriverData = new JT_0702_old();
			oldDriverData.ReadFromBytes(bytes);
			return;
		}
		this.CardState = (bytes[0]);
		
		this.OperTime = "20" + String.format("%02X", bytes[1]) + "-"
				+ String.format("%02X", bytes[2]) + "-"
				+ String.format("%02X", bytes[3]) + " "
				+ String.format("%02X", bytes[4]) + ":"
				+ String.format("%02X", bytes[5]) + ":"
				+ String.format("%02X", bytes[6]);
		 this.ReadResult = bytes[7];

         DriverNameLength = bytes[8];
         
         this.DriverName = BitConverter.getString(bytes, 9, DriverNameLength);
         this.CertificationCode = BitConverter.getString(bytes, 9+1+DriverNameLength, 20);
         AgencyNameLength = bytes[DriverNameLength + 29];
         this.AgencyName = BitConverter.getString(bytes, 30+DriverNameLength, AgencyNameLength);
         int pos = DriverNameLength + 29 + AgencyNameLength;
         this.ValidateDate  =  "20" + String.format("%02X", bytes[pos+1]) + "-"
 				+ String.format("%02X", bytes[pos+2]) + "-"
 				+ String.format("%02X", bytes[pos+3]) + " "
 				+ String.format("%02X", bytes[pos+4]) + ":"
 				+ String.format("%02X", bytes[pos+5]) + ":"
 				+ String.format("%02X", bytes[pos+6]);
         
	}
	

	public byte getCardState() {
		return CardState;
	}

	public void setCardState(byte cardState) {
		CardState = cardState;
	}

	public String getOperTime() {
		return OperTime;
	}

	public void setOperTime(String operTime) {
		OperTime = operTime;
	}

	public byte getReadResult() {
		return ReadResult;
	}

	public void setReadResult(byte readResult) {
		ReadResult = readResult;
	}

	public byte getDriverNameLength() {
		return DriverNameLength;
	}

	public void setDriverNameLength(byte driverNameLength) {
		DriverNameLength = driverNameLength;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getCertificationCode() {
		return CertificationCode;
	}

	public void setCertificationCode(String certificationCode) {
		CertificationCode = certificationCode;
	}

	public byte getAgencyNameLength() {
		return AgencyNameLength;
	}

	public void setAgencyNameLength(byte agencyNameLength) {
		AgencyNameLength = agencyNameLength;
	}

	public String getAgencyName() {
		return AgencyName;
	}

	public void setAgencyName(String agencyName) {
		AgencyName = agencyName;
	}

	public String getValidateDate() {
		return ValidateDate;
	}

	public void setValidateDate(String validateDate) {
		ValidateDate = validateDate;
	}


	public JT_0702_old getOldDriverData() {
		return oldDriverData;
	}


	public void setOldDriverData(JT_0702_old oldDriverData) {
		this.oldDriverData = oldDriverData;
	}
}
