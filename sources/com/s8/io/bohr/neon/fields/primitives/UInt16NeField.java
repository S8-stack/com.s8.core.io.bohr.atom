package com.s8.io.bohr.neon.fields.primitives;

import java.io.IOException;

import com.s8.io.bohr.BOHR_Types;
import com.s8.io.bohr.neon.core.BuildScope;
import com.s8.io.bohr.neon.core.NeObjectPrototype;
import com.s8.io.bohr.neon.fields.NeValue;
import com.s8.io.bytes.alpha.ByteInflow;
import com.s8.io.bytes.alpha.ByteOutflow;


/**
 * 
 *
 * @author Pierre Convert
 * Copyright (C) 2022, Pierre Convert. All rights reserved.
 * 
 */
public class UInt16NeField extends PrimitiveNeField {

	
	public final static long SIGNATURE = BOHR_Types.UINT16;

	public @Override long getSignature() { return SIGNATURE; }



	public UInt16NeField(NeObjectPrototype prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.UINT16);
	}

	/**
	 * 
	 * @param values
	 * @return
	 */
	public int get(NeValue wrapper) {
		return ((Value) wrapper).value;
	}
	
	
	/**
	 * 
	 * @param values
	 * @param value
	 */
	public void set(NeValue wrapper, int value) {
		((Value) wrapper).value = value;
	}
	

	@Override
	public NeValue createValue() {
		return new Value();
	}

	
	
	/**
	 * 
	 * @author pierreconvert
	 *
	 */
	public static class Value extends PrimitiveNeField.Value {
		
		private int value;
	
		public Value() {
			super();
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putUInt16(value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getUInt16();
		}
	}
}
