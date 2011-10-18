/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.sccp.impl.parameter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.mobicents.protocols.ss7.sccp.parameter.ReturnCause;

/**
 * 
 * @author baranowb
 */
public class ReturnCauseImpl extends AbstractParameter implements ReturnCause {

	private int value;

	public ReturnCauseImpl() {
	}

	public ReturnCauseImpl(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void decode(InputStream in) throws IOException {
		if (in.read() != 1) {
			throw new IOException();
		}

		int b = in.read() & 0xFf;

		this.value = b;
	}

	public void encode(OutputStream out) throws IOException {
		byte b = (byte) (this.value);
		out.write(1);
		out.write(b);
	}

	public void decode(byte[] bb) throws IOException {
		int b = bb[0] & 0xff;

		this.value = b;
	}

	public byte[] encode() throws IOException {
		return new byte[] { (byte) this.value };
	}

	public String toString() {
		switch (this.value) {
		case NO_TRANSLATION_FOR_NATURE:
			return "NO_TRANSLATION_FOR_NATURE";
		case NO_TRANSLATION_FOR_ADDRESS:
			return "NO_TRANSLATION_FOR_ADDRESS";
		case SUBSYSTEM_CONGESTION:
			return "SUBSYSTEM_CONGESTION";
		case SUBSYSTEM_FAILURE:
			return "SUBSYSTEM_FAILURE";
		case UNEQUIPED_USER:
			return "UNEQUIPED_USER";
		case MTP_FAILURE:
			return "MTP_FAILURE";
		case NETWORK_CONGESTION:
			return "NETWORK_CONGESTION";
		case UNQALIFIED:
			return "UNQALIFIED";
		case ERR_IN_MSG_TRANSPORT:
			return "ERR_IN_MSG_TRANSPORT";
		case ERR_IN_LOCAL_PROCESSING:
			return "ERR_IN_LOCAL_PROCESSING";
		case CANNOT_REASEMBLE:
			return "CANNOT_REASEMBLE";
		case SCCP_FAILURE:
			return "SCCP_FAILURE";
		case HOP_COUNTER_VIOLATION:
			return "HOP_COUNTER_VIOLATION";
		case SEG_NOT_SUPPORTED:
			return "SEG_NOT_SUPPORTED";
		case SEG_FAILURE:
			return "SEG_FAILURE";
		default:
			return ("Unidentified ReturnCause" + this.value);

		}
	}

}