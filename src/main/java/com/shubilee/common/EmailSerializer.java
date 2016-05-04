package com.shubilee.common;

import org.springframework.util.SerializationUtils;

import com.shubilee.entity.Sendmail;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

public class EmailSerializer implements Encoder<Sendmail>{
	public EmailSerializer(VerifiableProperties properties){
		
	}
	@Override
	public byte[] toBytes(Sendmail sendmail) {
		return SerializationUtils.serialize(sendmail);
	}
}




