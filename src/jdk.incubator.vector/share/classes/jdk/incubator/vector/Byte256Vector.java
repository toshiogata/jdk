/*
 * Copyright (c) 2017, 2025, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package jdk.incubator.vector;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

import jdk.internal.vm.annotation.ForceInline;
import jdk.internal.vm.vector.VectorSupport;

import static jdk.internal.vm.vector.VectorSupport.*;

import static jdk.incubator.vector.VectorOperators.*;

// -- This file was mechanically generated: Do not edit! -- //

@SuppressWarnings("cast")  // warning: redundant cast
final class Byte256Vector extends ByteVector {
    static final ByteSpecies VSPECIES =
        (ByteSpecies) ByteVector.SPECIES_256;

    static final VectorShape VSHAPE =
        VSPECIES.vectorShape();

    static final Class<Byte256Vector> VCLASS = Byte256Vector.class;

    static final int VSIZE = VSPECIES.vectorBitSize();

    static final int VLENGTH = VSPECIES.laneCount(); // used by the JVM

    static final Class<Byte> ETYPE = byte.class; // used by the JVM

    Byte256Vector(byte[] v) {
        super(v);
    }

    // For compatibility as Byte256Vector::new,
    // stored into species.vectorFactory.
    Byte256Vector(Object v) {
        this((byte[]) v);
    }

    static final Byte256Vector ZERO = new Byte256Vector(new byte[VLENGTH]);
    static final Byte256Vector IOTA = new Byte256Vector(VSPECIES.iotaArray());

    static {
        // Warm up a few species caches.
        // If we do this too much we will
        // get NPEs from bootstrap circularity.
        VSPECIES.dummyVector();
        VSPECIES.withLanes(LaneType.BYTE);
    }

    // Specialized extractors

    @ForceInline
    final @Override
    public ByteSpecies vspecies() {
        // ISSUE:  This should probably be a @Stable
        // field inside AbstractVector, rather than
        // a megamorphic method.
        return VSPECIES;
    }

    @ForceInline
    @Override
    public final Class<Byte> elementType() { return byte.class; }

    @ForceInline
    @Override
    public final int elementSize() { return Byte.SIZE; }

    @ForceInline
    @Override
    public final VectorShape shape() { return VSHAPE; }

    @ForceInline
    @Override
    public final int length() { return VLENGTH; }

    @ForceInline
    @Override
    public final int bitSize() { return VSIZE; }

    @ForceInline
    @Override
    public final int byteSize() { return VSIZE / Byte.SIZE; }

    /*package-private*/
    @ForceInline
    final @Override
    byte[] vec() {
        return (byte[])getPayload();
    }

    // Virtualized constructors

    @Override
    @ForceInline
    public final Byte256Vector broadcast(byte e) {
        return (Byte256Vector) super.broadcastTemplate(e);  // specialize
    }

    @Override
    @ForceInline
    public final Byte256Vector broadcast(long e) {
        return (Byte256Vector) super.broadcastTemplate(e);  // specialize
    }

    @Override
    @ForceInline
    Byte256Mask maskFromArray(boolean[] bits) {
        return new Byte256Mask(bits);
    }

    @Override
    @ForceInline
    Byte256Shuffle iotaShuffle() { return Byte256Shuffle.IOTA; }

    @Override
    @ForceInline
    Byte256Shuffle iotaShuffle(int start, int step, boolean wrap) {
        return (Byte256Shuffle) iotaShuffleTemplate((byte) start, (byte) step, wrap);
    }

    @Override
    @ForceInline
    Byte256Shuffle shuffleFromArray(int[] indices, int i) { return new Byte256Shuffle(indices, i); }

    @Override
    @ForceInline
    Byte256Shuffle shuffleFromOp(IntUnaryOperator fn) { return new Byte256Shuffle(fn); }

    // Make a vector of the same species but the given elements:
    @ForceInline
    final @Override
    Byte256Vector vectorFactory(byte[] vec) {
        return new Byte256Vector(vec);
    }

    @ForceInline
    final @Override
    Byte256Vector asByteVectorRaw() {
        return (Byte256Vector) super.asByteVectorRawTemplate();  // specialize
    }

    @ForceInline
    final @Override
    AbstractVector<?> asVectorRaw(LaneType laneType) {
        return super.asVectorRawTemplate(laneType);  // specialize
    }

    // Unary operator

    @ForceInline
    final @Override
    Byte256Vector uOp(FUnOp f) {
        return (Byte256Vector) super.uOpTemplate(f);  // specialize
    }

    @ForceInline
    final @Override
    Byte256Vector uOp(VectorMask<Byte> m, FUnOp f) {
        return (Byte256Vector)
            super.uOpTemplate((Byte256Mask)m, f);  // specialize
    }

    // Binary operator

    @ForceInline
    final @Override
    Byte256Vector bOp(Vector<Byte> v, FBinOp f) {
        return (Byte256Vector) super.bOpTemplate((Byte256Vector)v, f);  // specialize
    }

    @ForceInline
    final @Override
    Byte256Vector bOp(Vector<Byte> v,
                     VectorMask<Byte> m, FBinOp f) {
        return (Byte256Vector)
            super.bOpTemplate((Byte256Vector)v, (Byte256Mask)m,
                              f);  // specialize
    }

    // Ternary operator

    @ForceInline
    final @Override
    Byte256Vector tOp(Vector<Byte> v1, Vector<Byte> v2, FTriOp f) {
        return (Byte256Vector)
            super.tOpTemplate((Byte256Vector)v1, (Byte256Vector)v2,
                              f);  // specialize
    }

    @ForceInline
    final @Override
    Byte256Vector tOp(Vector<Byte> v1, Vector<Byte> v2,
                     VectorMask<Byte> m, FTriOp f) {
        return (Byte256Vector)
            super.tOpTemplate((Byte256Vector)v1, (Byte256Vector)v2,
                              (Byte256Mask)m, f);  // specialize
    }

    @ForceInline
    final @Override
    byte rOp(byte v, VectorMask<Byte> m, FBinOp f) {
        return super.rOpTemplate(v, m, f);  // specialize
    }

    @Override
    @ForceInline
    public final <F>
    Vector<F> convertShape(VectorOperators.Conversion<Byte,F> conv,
                           VectorSpecies<F> rsp, int part) {
        return super.convertShapeTemplate(conv, rsp, part);  // specialize
    }

    @Override
    @ForceInline
    public final <F>
    Vector<F> reinterpretShape(VectorSpecies<F> toSpecies, int part) {
        return super.reinterpretShapeTemplate(toSpecies, part);  // specialize
    }

    // Specialized algebraic operations:

    // The following definition forces a specialized version of this
    // crucial method into the v-table of this class.  A call to add()
    // will inline to a call to lanewise(ADD,), at which point the JIT
    // intrinsic will have the opcode of ADD, plus all the metadata
    // for this particular class, enabling it to generate precise
    // code.
    //
    // There is probably no benefit to the JIT to specialize the
    // masked or broadcast versions of the lanewise method.

    @Override
    @ForceInline
    public Byte256Vector lanewise(Unary op) {
        return (Byte256Vector) super.lanewiseTemplate(op);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector lanewise(Unary op, VectorMask<Byte> m) {
        return (Byte256Vector) super.lanewiseTemplate(op, Byte256Mask.class, (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector lanewise(Binary op, Vector<Byte> v) {
        return (Byte256Vector) super.lanewiseTemplate(op, v);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector lanewise(Binary op, Vector<Byte> v, VectorMask<Byte> m) {
        return (Byte256Vector) super.lanewiseTemplate(op, Byte256Mask.class, v, (Byte256Mask) m);  // specialize
    }

    /*package-private*/
    @Override
    @ForceInline Byte256Vector
    lanewiseShift(VectorOperators.Binary op, int e) {
        return (Byte256Vector) super.lanewiseShiftTemplate(op, e);  // specialize
    }

    /*package-private*/
    @Override
    @ForceInline Byte256Vector
    lanewiseShift(VectorOperators.Binary op, int e, VectorMask<Byte> m) {
        return (Byte256Vector) super.lanewiseShiftTemplate(op, Byte256Mask.class, e, (Byte256Mask) m);  // specialize
    }

    /*package-private*/
    @Override
    @ForceInline
    public final
    Byte256Vector
    lanewise(Ternary op, Vector<Byte> v1, Vector<Byte> v2) {
        return (Byte256Vector) super.lanewiseTemplate(op, v1, v2);  // specialize
    }

    @Override
    @ForceInline
    public final
    Byte256Vector
    lanewise(Ternary op, Vector<Byte> v1, Vector<Byte> v2, VectorMask<Byte> m) {
        return (Byte256Vector) super.lanewiseTemplate(op, Byte256Mask.class, v1, v2, (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public final
    Byte256Vector addIndex(int scale) {
        return (Byte256Vector) super.addIndexTemplate(scale);  // specialize
    }

    // Type specific horizontal reductions

    @Override
    @ForceInline
    public final byte reduceLanes(VectorOperators.Associative op) {
        return super.reduceLanesTemplate(op);  // specialized
    }

    @Override
    @ForceInline
    public final byte reduceLanes(VectorOperators.Associative op,
                                    VectorMask<Byte> m) {
        return super.reduceLanesTemplate(op, Byte256Mask.class, (Byte256Mask) m);  // specialized
    }

    @Override
    @ForceInline
    public final long reduceLanesToLong(VectorOperators.Associative op) {
        return (long) super.reduceLanesTemplate(op);  // specialized
    }

    @Override
    @ForceInline
    public final long reduceLanesToLong(VectorOperators.Associative op,
                                        VectorMask<Byte> m) {
        return (long) super.reduceLanesTemplate(op, Byte256Mask.class, (Byte256Mask) m);  // specialized
    }

    @Override
    @ForceInline
    final <F> VectorShuffle<F> bitsToShuffle(AbstractSpecies<F> dsp) {
        return bitsToShuffleTemplate(dsp);
    }

    @Override
    @ForceInline
    public final Byte256Shuffle toShuffle() {
        return (Byte256Shuffle) toShuffle(vspecies(), false);
    }

    // Specialized unary testing

    @Override
    @ForceInline
    public final Byte256Mask test(Test op) {
        return super.testTemplate(Byte256Mask.class, op);  // specialize
    }

    @Override
    @ForceInline
    public final Byte256Mask test(Test op, VectorMask<Byte> m) {
        return super.testTemplate(Byte256Mask.class, op, (Byte256Mask) m);  // specialize
    }

    // Specialized comparisons

    @Override
    @ForceInline
    public final Byte256Mask compare(Comparison op, Vector<Byte> v) {
        return super.compareTemplate(Byte256Mask.class, op, v);  // specialize
    }

    @Override
    @ForceInline
    public final Byte256Mask compare(Comparison op, byte s) {
        return super.compareTemplate(Byte256Mask.class, op, s);  // specialize
    }

    @Override
    @ForceInline
    public final Byte256Mask compare(Comparison op, long s) {
        return super.compareTemplate(Byte256Mask.class, op, s);  // specialize
    }

    @Override
    @ForceInline
    public final Byte256Mask compare(Comparison op, Vector<Byte> v, VectorMask<Byte> m) {
        return super.compareTemplate(Byte256Mask.class, op, v, (Byte256Mask) m);
    }


    @Override
    @ForceInline
    public Byte256Vector blend(Vector<Byte> v, VectorMask<Byte> m) {
        return (Byte256Vector)
            super.blendTemplate(Byte256Mask.class,
                                (Byte256Vector) v,
                                (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector slice(int origin, Vector<Byte> v) {
        return (Byte256Vector) super.sliceTemplate(origin, v);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector slice(int origin) {
        return (Byte256Vector) super.sliceTemplate(origin);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector unslice(int origin, Vector<Byte> w, int part) {
        return (Byte256Vector) super.unsliceTemplate(origin, w, part);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector unslice(int origin, Vector<Byte> w, int part, VectorMask<Byte> m) {
        return (Byte256Vector)
            super.unsliceTemplate(Byte256Mask.class,
                                  origin, w, part,
                                  (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector unslice(int origin) {
        return (Byte256Vector) super.unsliceTemplate(origin);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector rearrange(VectorShuffle<Byte> s) {
        return (Byte256Vector)
            super.rearrangeTemplate(Byte256Shuffle.class,
                                    (Byte256Shuffle) s);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector rearrange(VectorShuffle<Byte> shuffle,
                                  VectorMask<Byte> m) {
        return (Byte256Vector)
            super.rearrangeTemplate(Byte256Shuffle.class,
                                    Byte256Mask.class,
                                    (Byte256Shuffle) shuffle,
                                    (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector rearrange(VectorShuffle<Byte> s,
                                  Vector<Byte> v) {
        return (Byte256Vector)
            super.rearrangeTemplate(Byte256Shuffle.class,
                                    (Byte256Shuffle) s,
                                    (Byte256Vector) v);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector compress(VectorMask<Byte> m) {
        return (Byte256Vector)
            super.compressTemplate(Byte256Mask.class,
                                   (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector expand(VectorMask<Byte> m) {
        return (Byte256Vector)
            super.expandTemplate(Byte256Mask.class,
                                   (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector selectFrom(Vector<Byte> v) {
        return (Byte256Vector)
            super.selectFromTemplate((Byte256Vector) v);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector selectFrom(Vector<Byte> v,
                                   VectorMask<Byte> m) {
        return (Byte256Vector)
            super.selectFromTemplate((Byte256Vector) v,
                                     Byte256Mask.class, (Byte256Mask) m);  // specialize
    }

    @Override
    @ForceInline
    public Byte256Vector selectFrom(Vector<Byte> v1,
                                   Vector<Byte> v2) {
        return (Byte256Vector)
            super.selectFromTemplate((Byte256Vector) v1, (Byte256Vector) v2);  // specialize
    }

    @ForceInline
    @Override
    public byte lane(int i) {
        switch(i) {
            case 0: return laneHelper(0);
            case 1: return laneHelper(1);
            case 2: return laneHelper(2);
            case 3: return laneHelper(3);
            case 4: return laneHelper(4);
            case 5: return laneHelper(5);
            case 6: return laneHelper(6);
            case 7: return laneHelper(7);
            case 8: return laneHelper(8);
            case 9: return laneHelper(9);
            case 10: return laneHelper(10);
            case 11: return laneHelper(11);
            case 12: return laneHelper(12);
            case 13: return laneHelper(13);
            case 14: return laneHelper(14);
            case 15: return laneHelper(15);
            case 16: return laneHelper(16);
            case 17: return laneHelper(17);
            case 18: return laneHelper(18);
            case 19: return laneHelper(19);
            case 20: return laneHelper(20);
            case 21: return laneHelper(21);
            case 22: return laneHelper(22);
            case 23: return laneHelper(23);
            case 24: return laneHelper(24);
            case 25: return laneHelper(25);
            case 26: return laneHelper(26);
            case 27: return laneHelper(27);
            case 28: return laneHelper(28);
            case 29: return laneHelper(29);
            case 30: return laneHelper(30);
            case 31: return laneHelper(31);
            default: throw new IllegalArgumentException("Index " + i + " must be zero or positive, and less than " + VLENGTH);
        }
    }

    @ForceInline
    public byte laneHelper(int i) {
        return (byte) VectorSupport.extract(
                                VCLASS, ETYPE, VLENGTH,
                                this, i,
                                (vec, ix) -> {
                                    byte[] vecarr = vec.vec();
                                    return (long)vecarr[ix];
                                });
    }

    @ForceInline
    @Override
    public Byte256Vector withLane(int i, byte e) {
        switch (i) {
            case 0: return withLaneHelper(0, e);
            case 1: return withLaneHelper(1, e);
            case 2: return withLaneHelper(2, e);
            case 3: return withLaneHelper(3, e);
            case 4: return withLaneHelper(4, e);
            case 5: return withLaneHelper(5, e);
            case 6: return withLaneHelper(6, e);
            case 7: return withLaneHelper(7, e);
            case 8: return withLaneHelper(8, e);
            case 9: return withLaneHelper(9, e);
            case 10: return withLaneHelper(10, e);
            case 11: return withLaneHelper(11, e);
            case 12: return withLaneHelper(12, e);
            case 13: return withLaneHelper(13, e);
            case 14: return withLaneHelper(14, e);
            case 15: return withLaneHelper(15, e);
            case 16: return withLaneHelper(16, e);
            case 17: return withLaneHelper(17, e);
            case 18: return withLaneHelper(18, e);
            case 19: return withLaneHelper(19, e);
            case 20: return withLaneHelper(20, e);
            case 21: return withLaneHelper(21, e);
            case 22: return withLaneHelper(22, e);
            case 23: return withLaneHelper(23, e);
            case 24: return withLaneHelper(24, e);
            case 25: return withLaneHelper(25, e);
            case 26: return withLaneHelper(26, e);
            case 27: return withLaneHelper(27, e);
            case 28: return withLaneHelper(28, e);
            case 29: return withLaneHelper(29, e);
            case 30: return withLaneHelper(30, e);
            case 31: return withLaneHelper(31, e);
            default: throw new IllegalArgumentException("Index " + i + " must be zero or positive, and less than " + VLENGTH);
        }
    }

    @ForceInline
    public Byte256Vector withLaneHelper(int i, byte e) {
        return VectorSupport.insert(
                                VCLASS, ETYPE, VLENGTH,
                                this, i, (long)e,
                                (v, ix, bits) -> {
                                    byte[] res = v.vec().clone();
                                    res[ix] = (byte)bits;
                                    return v.vectorFactory(res);
                                });
    }

    // Mask

    static final class Byte256Mask extends AbstractMask<Byte> {
        static final int VLENGTH = VSPECIES.laneCount();    // used by the JVM
        static final Class<Byte> ETYPE = byte.class; // used by the JVM

        Byte256Mask(boolean[] bits) {
            this(bits, 0);
        }

        Byte256Mask(boolean[] bits, int offset) {
            super(prepare(bits, offset));
        }

        Byte256Mask(boolean val) {
            super(prepare(val));
        }

        private static boolean[] prepare(boolean[] bits, int offset) {
            boolean[] newBits = new boolean[VSPECIES.laneCount()];
            for (int i = 0; i < newBits.length; i++) {
                newBits[i] = bits[offset + i];
            }
            return newBits;
        }

        private static boolean[] prepare(boolean val) {
            boolean[] bits = new boolean[VSPECIES.laneCount()];
            Arrays.fill(bits, val);
            return bits;
        }

        @ForceInline
        final @Override
        public ByteSpecies vspecies() {
            // ISSUE:  This should probably be a @Stable
            // field inside AbstractMask, rather than
            // a megamorphic method.
            return VSPECIES;
        }

        @ForceInline
        boolean[] getBits() {
            return (boolean[])getPayload();
        }

        @Override
        Byte256Mask uOp(MUnOp f) {
            boolean[] res = new boolean[vspecies().laneCount()];
            boolean[] bits = getBits();
            for (int i = 0; i < res.length; i++) {
                res[i] = f.apply(i, bits[i]);
            }
            return new Byte256Mask(res);
        }

        @Override
        Byte256Mask bOp(VectorMask<Byte> m, MBinOp f) {
            boolean[] res = new boolean[vspecies().laneCount()];
            boolean[] bits = getBits();
            boolean[] mbits = ((Byte256Mask)m).getBits();
            for (int i = 0; i < res.length; i++) {
                res[i] = f.apply(i, bits[i], mbits[i]);
            }
            return new Byte256Mask(res);
        }

        @ForceInline
        @Override
        public final
        Byte256Vector toVector() {
            return (Byte256Vector) super.toVectorTemplate();  // specialize
        }

        /**
         * Helper function for lane-wise mask conversions.
         * This function kicks in after intrinsic failure.
         */
        @ForceInline
        private final <E>
        VectorMask<E> defaultMaskCast(AbstractSpecies<E> dsp) {
            if (length() != dsp.laneCount())
                throw new IllegalArgumentException("VectorMask length and species length differ");
            boolean[] maskArray = toArray();
            return  dsp.maskFactory(maskArray).check(dsp);
        }

        @Override
        @ForceInline
        public <E> VectorMask<E> cast(VectorSpecies<E> dsp) {
            AbstractSpecies<E> species = (AbstractSpecies<E>) dsp;
            if (length() != species.laneCount())
                throw new IllegalArgumentException("VectorMask length and species length differ");

            return VectorSupport.convert(VectorSupport.VECTOR_OP_CAST,
                this.getClass(), ETYPE, VLENGTH,
                species.maskType(), species.elementType(), VLENGTH,
                this, species,
                (m, s) -> s.maskFactory(m.toArray()).check(s));
        }

        @Override
        @ForceInline
        /*package-private*/
        Byte256Mask indexPartiallyInUpperRange(long offset, long limit) {
            return (Byte256Mask) VectorSupport.indexPartiallyInUpperRange(
                Byte256Mask.class, byte.class, VLENGTH, offset, limit,
                (o, l) -> (Byte256Mask) TRUE_MASK.indexPartiallyInRange(o, l));
        }

        // Unary operations

        @Override
        @ForceInline
        public Byte256Mask not() {
            return xor(maskAll(true));
        }

        @Override
        @ForceInline
        public Byte256Mask compress() {
            return (Byte256Mask)VectorSupport.compressExpandOp(VectorSupport.VECTOR_OP_MASK_COMPRESS,
                Byte256Vector.class, Byte256Mask.class, ETYPE, VLENGTH, null, this,
                (v1, m1) -> VSPECIES.iota().compare(VectorOperators.LT, m1.trueCount()));
        }


        // Binary operations

        @Override
        @ForceInline
        public Byte256Mask and(VectorMask<Byte> mask) {
            Objects.requireNonNull(mask);
            Byte256Mask m = (Byte256Mask)mask;
            return VectorSupport.binaryOp(VECTOR_OP_AND, Byte256Mask.class, null, byte.class, VLENGTH,
                                          this, m, null,
                                          (m1, m2, vm) -> m1.bOp(m2, (i, a, b) -> a & b));
        }

        @Override
        @ForceInline
        public Byte256Mask or(VectorMask<Byte> mask) {
            Objects.requireNonNull(mask);
            Byte256Mask m = (Byte256Mask)mask;
            return VectorSupport.binaryOp(VECTOR_OP_OR, Byte256Mask.class, null, byte.class, VLENGTH,
                                          this, m, null,
                                          (m1, m2, vm) -> m1.bOp(m2, (i, a, b) -> a | b));
        }

        @Override
        @ForceInline
        public Byte256Mask xor(VectorMask<Byte> mask) {
            Objects.requireNonNull(mask);
            Byte256Mask m = (Byte256Mask)mask;
            return VectorSupport.binaryOp(VECTOR_OP_XOR, Byte256Mask.class, null, byte.class, VLENGTH,
                                          this, m, null,
                                          (m1, m2, vm) -> m1.bOp(m2, (i, a, b) -> a ^ b));
        }

        // Mask Query operations

        @Override
        @ForceInline
        public int trueCount() {
            return (int) VectorSupport.maskReductionCoerced(VECTOR_OP_MASK_TRUECOUNT, Byte256Mask.class, byte.class, VLENGTH, this,
                                                      (m) -> trueCountHelper(m.getBits()));
        }

        @Override
        @ForceInline
        public int firstTrue() {
            return (int) VectorSupport.maskReductionCoerced(VECTOR_OP_MASK_FIRSTTRUE, Byte256Mask.class, byte.class, VLENGTH, this,
                                                      (m) -> firstTrueHelper(m.getBits()));
        }

        @Override
        @ForceInline
        public int lastTrue() {
            return (int) VectorSupport.maskReductionCoerced(VECTOR_OP_MASK_LASTTRUE, Byte256Mask.class, byte.class, VLENGTH, this,
                                                      (m) -> lastTrueHelper(m.getBits()));
        }

        @Override
        @ForceInline
        public long toLong() {
            if (length() > Long.SIZE) {
                throw new UnsupportedOperationException("too many lanes for one long");
            }
            return VectorSupport.maskReductionCoerced(VECTOR_OP_MASK_TOLONG, Byte256Mask.class, byte.class, VLENGTH, this,
                                                      (m) -> toLongHelper(m.getBits()));
        }

        // laneIsSet

        @Override
        @ForceInline
        public boolean laneIsSet(int i) {
            Objects.checkIndex(i, length());
            return VectorSupport.extract(Byte256Mask.class, byte.class, VLENGTH,
                                         this, i, (m, idx) -> (m.getBits()[idx] ? 1L : 0L)) == 1L;
        }

        // Reductions

        @Override
        @ForceInline
        public boolean anyTrue() {
            return VectorSupport.test(BT_ne, Byte256Mask.class, byte.class, VLENGTH,
                                         this, vspecies().maskAll(true),
                                         (m, __) -> anyTrueHelper(((Byte256Mask)m).getBits()));
        }

        @Override
        @ForceInline
        public boolean allTrue() {
            return VectorSupport.test(BT_overflow, Byte256Mask.class, byte.class, VLENGTH,
                                         this, vspecies().maskAll(true),
                                         (m, __) -> allTrueHelper(((Byte256Mask)m).getBits()));
        }

        @ForceInline
        /*package-private*/
        static Byte256Mask maskAll(boolean bit) {
            return VectorSupport.fromBitsCoerced(Byte256Mask.class, byte.class, VLENGTH,
                                                 (bit ? -1 : 0), MODE_BROADCAST, null,
                                                 (v, __) -> (v != 0 ? TRUE_MASK : FALSE_MASK));
        }
        private static final Byte256Mask  TRUE_MASK = new Byte256Mask(true);
        private static final Byte256Mask FALSE_MASK = new Byte256Mask(false);

    }

    // Shuffle

    static final class Byte256Shuffle extends AbstractShuffle<Byte> {
        static final int VLENGTH = VSPECIES.laneCount();    // used by the JVM
        static final Class<Byte> ETYPE = byte.class; // used by the JVM

        Byte256Shuffle(byte[] indices) {
            super(indices);
            assert(VLENGTH == indices.length);
            assert(indicesInRange(indices));
        }

        Byte256Shuffle(int[] indices, int i) {
            this(prepare(indices, i));
        }

        Byte256Shuffle(IntUnaryOperator fn) {
            this(prepare(fn));
        }

        byte[] indices() {
            return (byte[])getPayload();
        }

        @Override
        @ForceInline
        public ByteSpecies vspecies() {
            return VSPECIES;
        }

        static {
            // There must be enough bits in the shuffle lanes to encode
            // VLENGTH valid indexes and VLENGTH exceptional ones.
            assert(VLENGTH < Byte.MAX_VALUE);
            assert(Byte.MIN_VALUE <= -VLENGTH);
        }
        static final Byte256Shuffle IOTA = new Byte256Shuffle(IDENTITY);

        @Override
        @ForceInline
        public Byte256Vector toVector() {
            return toBitsVector();
        }

        @Override
        @ForceInline
        Byte256Vector toBitsVector() {
            return (Byte256Vector) super.toBitsVectorTemplate();
        }

        @Override
        Byte256Vector toBitsVector0() {
            return ((Byte256Vector) vspecies().asIntegral().dummyVector()).vectorFactory(indices());
        }

        @Override
        @ForceInline
        public int laneSource(int i) {
            return (int)toBitsVector().lane(i);
        }

        @Override
        @ForceInline
        public void intoArray(int[] a, int offset) {
            VectorSpecies<Integer> species = IntVector.SPECIES_256;
            Vector<Byte> v = toBitsVector();
            v.convertShape(VectorOperators.B2I, species, 0)
                    .reinterpretAsInts()
                    .intoArray(a, offset);
            v.convertShape(VectorOperators.B2I, species, 1)
                    .reinterpretAsInts()
                    .intoArray(a, offset + species.length());
            v.convertShape(VectorOperators.B2I, species, 2)
                    .reinterpretAsInts()
                    .intoArray(a, offset + species.length() * 2);
            v.convertShape(VectorOperators.B2I, species, 3)
                    .reinterpretAsInts()
                    .intoArray(a, offset + species.length() * 3);
        }

        @Override
        @ForceInline
        public void intoMemorySegment(MemorySegment ms, long offset, ByteOrder bo) {
            VectorSpecies<Integer> species = IntVector.SPECIES_256;
            Vector<Byte> v = toBitsVector();
            v.convertShape(VectorOperators.B2I, species, 0)
                    .reinterpretAsInts()
                    .intoMemorySegment(ms, offset, bo);
            v.convertShape(VectorOperators.B2I, species, 1)
                    .reinterpretAsInts()
                    .intoMemorySegment(ms, offset + species.vectorByteSize(), bo);
            v.convertShape(VectorOperators.B2I, species, 2)
                    .reinterpretAsInts()
                    .intoMemorySegment(ms, offset + species.vectorByteSize() * 2, bo);
            v.convertShape(VectorOperators.B2I, species, 3)
                    .reinterpretAsInts()
                    .intoMemorySegment(ms, offset + species.vectorByteSize() * 3, bo);
         }

        @Override
        @ForceInline
        public final Byte256Mask laneIsValid() {
            return (Byte256Mask) toBitsVector().compare(VectorOperators.GE, 0)
                    .cast(vspecies());
        }

        @ForceInline
        @Override
        public final Byte256Shuffle rearrange(VectorShuffle<Byte> shuffle) {
            Byte256Shuffle concreteShuffle = (Byte256Shuffle) shuffle;
            return (Byte256Shuffle) toBitsVector().rearrange(concreteShuffle)
                    .toShuffle(vspecies(), false);
        }

        @ForceInline
        @Override
        public final Byte256Shuffle wrapIndexes() {
            Byte256Vector v = toBitsVector();
            if ((length() & (length() - 1)) == 0) {
                v = (Byte256Vector) v.lanewise(VectorOperators.AND, length() - 1);
            } else {
                v = (Byte256Vector) v.blend(v.lanewise(VectorOperators.ADD, length()),
                            v.compare(VectorOperators.LT, 0));
            }
            return (Byte256Shuffle) v.toShuffle(vspecies(), false);
        }

        private static byte[] prepare(int[] indices, int offset) {
            byte[] a = new byte[VLENGTH];
            for (int i = 0; i < VLENGTH; i++) {
                int si = indices[offset + i];
                si = partiallyWrapIndex(si, VLENGTH);
                a[i] = (byte)si;
            }
            return a;
        }

        private static byte[] prepare(IntUnaryOperator f) {
            byte[] a = new byte[VLENGTH];
            for (int i = 0; i < VLENGTH; i++) {
                int si = f.applyAsInt(i);
                si = partiallyWrapIndex(si, VLENGTH);
                a[i] = (byte)si;
            }
            return a;
        }

        private static boolean indicesInRange(byte[] indices) {
            int length = indices.length;
            for (byte si : indices) {
                if (si >= (byte)length || si < (byte)(-length)) {
                    String msg = ("index "+si+"out of range ["+length+"] in "+
                                  java.util.Arrays.toString(indices));
                    throw new AssertionError(msg);
                }
            }
            return true;
        }
    }

    // ================================================

    // Specialized low-level memory operations.

    @ForceInline
    @Override
    final
    ByteVector fromArray0(byte[] a, int offset) {
        return super.fromArray0Template(a, offset);  // specialize
    }

    @ForceInline
    @Override
    final
    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
        return super.fromArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);  // specialize
    }

    @ForceInline
    @Override
    final
    ByteVector fromArray0(byte[] a, int offset, int[] indexMap, int mapOffset, VectorMask<Byte> m) {
        return super.fromArray0Template(Byte256Mask.class, a, offset, indexMap, mapOffset, (Byte256Mask) m);
    }


    @ForceInline
    @Override
    final
    ByteVector fromBooleanArray0(boolean[] a, int offset) {
        return super.fromBooleanArray0Template(a, offset);  // specialize
    }

    @ForceInline
    @Override
    final
    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
        return super.fromBooleanArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);  // specialize
    }

    @ForceInline
    @Override
    final
    ByteVector fromMemorySegment0(MemorySegment ms, long offset) {
        return super.fromMemorySegment0Template(ms, offset);  // specialize
    }

    @ForceInline
    @Override
    final
    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange) {
        return super.fromMemorySegment0Template(Byte256Mask.class, ms, offset, (Byte256Mask) m, offsetInRange);  // specialize
    }

    @ForceInline
    @Override
    final
    void intoArray0(byte[] a, int offset) {
        super.intoArray0Template(a, offset);  // specialize
    }

    @ForceInline
    @Override
    final
    void intoArray0(byte[] a, int offset, VectorMask<Byte> m) {
        super.intoArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);
    }


    @ForceInline
    @Override
    final
    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
        super.intoBooleanArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);
    }

    @ForceInline
    @Override
    final
    void intoMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m) {
        super.intoMemorySegment0Template(Byte256Mask.class, ms, offset, (Byte256Mask) m);
    }


    // End of specialized low-level memory operations.

    // ================================================

}

