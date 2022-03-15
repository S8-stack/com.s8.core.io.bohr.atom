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
public class Float32NeField extends PrimitiveNeField {

	
	
	public final static long SIGNATURE = BOHR_Types.FLOAT32;

	public @Override long getSignature() { return SIGNATURE; }



	public Float32NeField(NeObjectPrototype prototype, String name) {
		super(prototype, name);
	}


	@Override
	public void publishEncoding(ByteOutflow outflow) throws IOException {
		outflow.putUInt8(BOHR_Types.FLOAT32);
	}
	
	
	/**
	 * 
	 * @param values
	 * @return
	 */
	public float get(NeValue wrapper) {
		return ((Value) wrapper).value;
	}
	
	
	/**
	 * 
	 * @param values
	 * @param value
	 */
	public void set(NeValue wrapper, float value) {
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
		
		private float value;
	
		public Value() {
			super();
		}

		@Override
		public void compose(ByteOutflow outflow) throws IOException {
			outflow.putFloat32(value);
		}

		@Override
		public void parse(ByteInflow inflow, BuildScope scope) throws IOException {
			value = inflow.getFloat32();
		}
	}
}
