/*
 *  Copyright 2008-2010 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.frameworkset.http;

import org.frameworkset.util.MultiValueMap;
import org.frameworkset.util.annotations.wraper.ResponseBodyWraper;

/**
 * <p>Title: ResponseEntity.java</p> 
 * <p>Description: </p>
 * <p>bboss workgroup</p>
 * <p>Copyright (c) 2008</p>
 * @Date 2010-11-21
 * @author biaoping.yin
 * @version 1.0
 */
public class ResponseEntity<T> extends HttpEntity<T> {

	private final HttpStatus statusCode;
	private ResponseBodyWraper reponseBodyWraper;
	private String datatype;
	private String charset;
	/**
	 * Create a new {@code ResponseEntity} with the given body and status code, and no headers.
	 * @param body the entity body
	 * @param statusCode the status code
	 */
	public ResponseEntity(T body, HttpStatus statusCode,String datatype,String charset) {
		super(body);
		this.statusCode = statusCode;
		this.datatype = datatype;
		this.charset = charset;
		initReponseBodyWraper();
	}
	
	private void initReponseBodyWraper()
	{
		
		if(this.body != null)
			this.reponseBodyWraper = new ResponseBodyWraper(  datatype,  charset,  body.getClass()) ;
	}


	 

	/**
	 * Create a new {@code HttpEntity} with the given body, headers, and status code.
	 * @param body the entity body
	 * @param headers the entity headers
	 * @param statusCode the status code
	 */
	public ResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus statusCode,String datatype,String charset) {
		super(body, headers);
		this.statusCode = statusCode;
		this.datatype = datatype;
		this.charset = charset;
		initReponseBodyWraper();
	}
 
	
	/**
	 * Create a new {@code ResponseEntity} with the given body and status code, and no headers.
	 * @param body the entity body
	 * @param statusCode the status code
	 */
	public ResponseEntity(T body, HttpStatus statusCode,String datatype) {
		super(body);
		this.statusCode = statusCode;
		this.datatype = datatype;
		initReponseBodyWraper();
	}


	 

	/**
	 * Create a new {@code HttpEntity} with the given body, headers, and status code.
	 * @param body the entity body
	 * @param headers the entity headers
	 * @param statusCode the status code
	 */
	public ResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus statusCode,String datatype) {
		super(body, headers);
		this.statusCode = statusCode;
		this.datatype = datatype;
		initReponseBodyWraper();
	}
	
	/**
	 * Create a new {@code ResponseEntity} with the given body and status code, and no headers.
	 
	 * @param statusCode the status code
	 */
	public ResponseEntity(HttpStatus statusCode) {
		super((T)null);
		this.statusCode = statusCode;
	}
	
	/**
	 * Create a new {@code ResponseEntity} with the given body and status code, and no headers.
	 * @param body the entity body
	 * @param statusCode the status code
	 */
	public ResponseEntity(T body, HttpStatus statusCode) {
		super(body);
		this.statusCode = statusCode;
		initReponseBodyWraper();
	}


	/**
	 * Create a new {@code HttpEntity} with the given headers and status code, and no body.
	 * @param headers the entity headers
	 * @param statusCode the status code
	 */
	public ResponseEntity(MultiValueMap<String, String> headers, HttpStatus statusCode) {
		super(headers);
		this.statusCode = statusCode;
	}

	/**
	 * Create a new {@code HttpEntity} with the given body, headers, and status code.
	 * @param body the entity body
	 * @param headers the entity headers
	 * @param statusCode the status code
	 */
	public ResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus statusCode) {
		super(body, headers);
		this.statusCode = statusCode;

		initReponseBodyWraper();
	}

	/**
	 * Return the HTTP status code of the response.
	 * @return the HTTP status as an HttpStatus enum value
	 */
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public ResponseBodyWraper getReponseBodyWraper() {
		return reponseBodyWraper;
	}

}
