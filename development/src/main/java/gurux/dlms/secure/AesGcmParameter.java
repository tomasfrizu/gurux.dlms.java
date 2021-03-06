//
// --------------------------------------------------------------------------
//  Gurux Ltd
// 
//
//
// Filename:        $HeadURL$
//
// Version:         $Revision$,
//                  $Date$
//                  $Author$
//
// Copyright (c) Gurux Ltd
//
//---------------------------------------------------------------------------
//
//  DESCRIPTION
//
// This file is a part of Gurux Device Framework.
//
// Gurux Device Framework is Open Source software; you can redistribute it
// and/or modify it under the terms of the GNU General Public License 
// as published by the Free Software Foundation; version 2 of the License.
// Gurux Device Framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of 
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
// See the GNU General Public License for more details.
//
// More information of Gurux products: http://www.gurux.org
//
// This code is licensed under the GNU General Public License v2. 
// Full text may be retrieved at http://www.gnu.org/licenses/gpl-2.0.txt
//---------------------------------------------------------------------------

package gurux.dlms.secure;

import gurux.dlms.enums.Security;
import gurux.dlms.internal.GXCommon;

public class AesGcmParameter {

    private byte tag;
    private Security security;
    private long frameCounter;

    private byte[] systemTitle;
    private byte[] blockCipherKey;
    private byte[] authenticationKey;
    private CountType type;
    private byte[] countTag;

    /**
     * Constructor.
     * 
     * @param forTag
     * @param forSecurity
     * @param forFrameCounter
     * @param forSystemTitle
     * @param forBlockCipherKey
     * @param forAuthenticationKey
     */
    public AesGcmParameter(final int forTag, final Security forSecurity,
            final long forFrameCounter, final byte[] forSystemTitle,
            final byte[] forBlockCipherKey, final byte[] forAuthenticationKey) {
        tag = (byte) forTag;
        security = forSecurity;
        frameCounter = forFrameCounter;

        systemTitle = forSystemTitle;
        blockCipherKey = forBlockCipherKey;
        authenticationKey = forAuthenticationKey;
        type = CountType.PACKET;
    }

    /**
     * Constructor.
     * 
     * @param forsystemTitle
     * @param forblockCipherKey
     * @param forauthenticationKey
     */
    public AesGcmParameter(final byte[] forsystemTitle,
            final byte[] forblockCipherKey, final byte[] forauthenticationKey) {
        systemTitle = forsystemTitle;
        blockCipherKey = forblockCipherKey;
        authenticationKey = forauthenticationKey;
        type = CountType.PACKET;
    }

    public final byte getTag() {
        return tag;
    }

    public final Security getSecurity() {
        return security;
    }

    public final void setSecurity(final Security value) {
        security = value;
    }

    public final long getFrameCounter() {
        return frameCounter;
    }

    public final void setFrameCounter(final long value) {
        frameCounter = value;
    }

    public final byte[] getSystemTitle() {
        return systemTitle;
    }

    public final void setSystemTitle(final byte[] value) {
        systemTitle = value;
    }

    public final byte[] getBlockCipherKey() {
        return blockCipherKey;
    }

    public final void setBlockCipherKey(final byte[] value) {
        blockCipherKey = value;
    }

    public final byte[] getAuthenticationKey() {
        return authenticationKey;
    }

    public final void setAuthenticationKey(final byte[] value) {
        authenticationKey = value;
    }

    public final CountType getType() {
        return type;
    }

    public final void setType(final CountType value) {
        type = value;
    }

    public final byte[] getCountTag() {
        return countTag;
    }

    public final void setCountTag(final byte[] value) {
        countTag = value;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Security: ");
        sb.append(getSecurity());
        sb.append(" FrameCounter: ");
        sb.append(getFrameCounter());
        sb.append(" SystemTitle: ");
        sb.append(GXCommon.toHex(systemTitle));
        sb.append(" AuthenticationKey: ");
        sb.append(GXCommon.toHex(authenticationKey));
        sb.append(" BlockCipherKey: ");
        sb.append(GXCommon.toHex(blockCipherKey));
        return sb.toString();
    }
}
