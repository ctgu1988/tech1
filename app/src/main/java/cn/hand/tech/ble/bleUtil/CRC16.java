package cn.hand.tech.ble.bleUtil;

public class CRC16
{
	static char[] auchCRC16Hi =
        {
                (char)0x00, (char)0x10, (char)0x20, (char)0x30, (char)0x40, (char)0x50, (char)0x60, (char)0x70,
                (char)0x81, (char)0x91, (char)0xa1, (char)0xb1, (char)0xc1, (char)0xd1, (char)0xe1, (char)0xf1,
                (char)0x12, (char)0x02, (char)0x32, (char)0x22, (char)0x52, (char)0x42, (char)0x72, (char)0x62,
                (char)0x93, (char)0x83, (char)0xb3, (char)0xa3, (char)0xd3, (char)0xc3, (char)0xf3, (char)0xe3,
                (char)0x24, (char)0x34, (char)0x04, (char)0x14, (char)0x64, (char)0x74, (char)0x44, (char)0x54,
                (char)0xa5, (char)0xb5, (char)0x85, (char)0x95, (char)0xe5, (char)0xf5, (char)0xc5, (char)0xd5,
                (char)0x36, (char)0x26, (char)0x16, (char)0x06, (char)0x76, (char)0x66, (char)0x56, (char)0x46,
                (char)0xb7, (char)0xa7, (char)0x97, (char)0x87, (char)0xf7, (char)0xe7, (char)0xd7, (char)0xc7,
                (char)0x48, (char)0x58, (char)0x68, (char)0x78, (char)0x08, (char)0x18, (char)0x28, (char)0x38,
                (char)0xc9, (char)0xd9, (char)0xe9, (char)0xf9, (char)0x89, (char)0x99, (char)0xa9, (char)0xb9,
                (char)0x5a, (char)0x4a, (char)0x7a, (char)0x6a, (char)0x1a, (char)0x0a, (char)0x3a, (char)0x2a,
                (char)0xdb, (char)0xcb, (char)0xfb, (char)0xeb, (char)0x9b, (char)0x8b, (char)0xbb, (char)0xab,
                (char)0x6c, (char)0x7c, (char)0x4c, (char)0x5c, (char)0x2c, (char)0x3c, (char)0x0c, (char)0x1c,
                (char)0xed, (char)0xfd, (char)0xcd, (char)0xdd, (char)0xad, (char)0xbd, (char)0x8d, (char)0x9d,
                (char)0x7e, (char)0x6e, (char)0x5e, (char)0x4e, (char)0x3e, (char)0x2e, (char)0x1e, (char)0x0e,
                (char)0xff, (char)0xef, (char)0xdf, (char)0xcf, (char)0xbf, (char)0xaf, (char)0x9f, (char)0x8f,
                (char)0x91, (char)0x81, (char)0xb1, (char)0xa1, (char)0xd1, (char)0xc1, (char)0xf1, (char)0xe1,
                (char)0x10, (char)0x00, (char)0x30, (char)0x20, (char)0x50, (char)0x40, (char)0x70, (char)0x60,
                (char)0x83, (char)0x93, (char)0xa3, (char)0xb3, (char)0xc3, (char)0xd3, (char)0xe3, (char)0xf3,
                (char)0x02, (char)0x12, (char)0x22, (char)0x32, (char)0x42, (char)0x52, (char)0x62, (char)0x72,
                (char)0xb5, (char)0xa5, (char)0x95, (char)0x85, (char)0xf5, (char)0xe5, (char)0xd5, (char)0xc5,
                (char)0x34, (char)0x24, (char)0x14, (char)0x04, (char)0x74, (char)0x64, (char)0x54, (char)0x44,
                (char)0xa7, (char)0xb7, (char)0x87, (char)0x97, (char)0xe7, (char)0xf7, (char)0xc7, (char)0xd7,
                (char)0x26, (char)0x36, (char)0x06, (char)0x16, (char)0x66, (char)0x76, (char)0x46, (char)0x56,
                (char)0xd9, (char)0xc9, (char)0xf9, (char)0xe9, (char)0x99, (char)0x89, (char)0xb9, (char)0xa9,
                (char)0x58, (char)0x48, (char)0x78, (char)0x68, (char)0x18, (char)0x08, (char)0x38, (char)0x28,
                (char)0xcb, (char)0xdb, (char)0xeb, (char)0xfb, (char)0x8b, (char)0x9b, (char)0xab, (char)0xbb,
                (char)0x4a, (char)0x5a, (char)0x6a, (char)0x7a, (char)0x0a, (char)0x1a, (char)0x2a, (char)0x3a,
                (char)0xfd, (char)0xed, (char)0xdd, (char)0xcd, (char)0xbd, (char)0xad, (char)0x9d, (char)0x8d,
                (char)0x7c, (char)0x6c, (char)0x5c, (char)0x4c, (char)0x3c, (char)0x2c, (char)0x1c, (char)0x0c,
                (char)0xef, (char)0xff, (char)0xcf, (char)0xdf, (char)0xaf, (char)0xbf, (char)0x8f, (char)0x9f,
                (char)0x6e, (char)0x7e, (char)0x4e, (char)0x5e, (char)0x2e, (char)0x3e, (char)0x0e, (char)0x1e
        };

static char[] auchCRC16Lo =
        {
                (char)0x00, (char)0x21, (char)0x42, (char)0x63, (char)0x84, (char)0xa5, (char)0xc6, (char)0xe7,
                (char)0x08, (char)0x29, (char)0x4a, (char)0x6b, (char)0x8c, (char)0xad, (char)0xce, (char)0xef,
                (char)0x31, (char)0x10, (char)0x73, (char)0x52, (char)0xb5, (char)0x94, (char)0xf7, (char)0xd6,
                (char)0x39, (char)0x18, (char)0x7b, (char)0x5a, (char)0xbd, (char)0x9c, (char)0xff, (char)0xde,
                (char)0x62, (char)0x43, (char)0x20, (char)0x01, (char)0xe6, (char)0xc7, (char)0xa4, (char)0x85,
                (char)0x6a, (char)0x4b, (char)0x28, (char)0x09, (char)0xee, (char)0xcf, (char)0xac, (char)0x8d,
                (char)0x53, (char)0x72, (char)0x11, (char)0x30, (char)0xd7, (char)0xf6, (char)0x95, (char)0xb4,
                (char)0x5b, (char)0x7a, (char)0x19, (char)0x38, (char)0xdf, (char)0xfe, (char)0x9d, (char)0xbc,
                (char)0xc4, (char)0xe5, (char)0x86, (char)0xa7, (char)0x40, (char)0x61, (char)0x02, (char)0x23,
                (char)0xcc, (char)0xed, (char)0x8e, (char)0xaf, (char)0x48, (char)0x69, (char)0x0a, (char)0x2b,
                (char)0xf5, (char)0xd4, (char)0xb7, (char)0x96, (char)0x71, (char)0x50, (char)0x33, (char)0x12,
                (char)0xfd, (char)0xdc, (char)0xbf, (char)0x9e, (char)0x79, (char)0x58, (char)0x3b, (char)0x1a,
                (char)0xa6, (char)0x87, (char)0xe4, (char)0xc5, (char)0x22, (char)0x03, (char)0x60, (char)0x41,
                (char)0xae, (char)0x8f, (char)0xec, (char)0xcd, (char)0x2a, (char)0x0b, (char)0x68, (char)0x49,
                (char)0x97, (char)0xb6, (char)0xd5, (char)0xf4, (char)0x13, (char)0x32, (char)0x51, (char)0x70,
                (char)0x9f, (char)0xbe, (char)0xdd, (char)0xfc, (char)0x1b, (char)0x3a, (char)0x59, (char)0x78,
                (char)0x88, (char)0xa9, (char)0xca, (char)0xeb, (char)0x0c, (char)0x2d, (char)0x4e, (char)0x6f,
                (char)0x80, (char)0xa1, (char)0xc2, (char)0xe3, (char)0x04, (char)0x25, (char)0x46, (char)0x67,
                (char)0xb9, (char)0x98, (char)0xfb, (char)0xda, (char)0x3d, (char)0x1c, (char)0x7f, (char)0x5e,
                (char)0xb1, (char)0x90, (char)0xf3, (char)0xd2, (char)0x35, (char)0x14, (char)0x77, (char)0x56,
                (char)0xea, (char)0xcb, (char)0xa8, (char)0x89, (char)0x6e, (char)0x4f, (char)0x2c, (char)0x0d,
                (char)0xe2, (char)0xc3, (char)0xa0, (char)0x81, (char)0x66, (char)0x47, (char)0x24, (char)0x05,
                (char)0xdb, (char)0xfa, (char)0x99, (char)0xb8, (char)0x5f, (char)0x7e, (char)0x1d, (char)0x3c,
                (char)0xd3, (char)0xf2, (char)0x91, (char)0xb0, (char)0x57, (char)0x76, (char)0x15, (char)0x34,
                (char)0x4c, (char)0x6d, (char)0x0e, (char)0x2f, (char)0xc8, (char)0xe9, (char)0x8a, (char)0xab,
                (char)0x44, (char)0x65, (char)0x06, (char)0x27, (char)0xc0, (char)0xe1, (char)0x82, (char)0xa3,
                (char)0x7d, (char)0x5c, (char)0x3f, (char)0x1e, (char)0xf9, (char)0xd8, (char)0xbb, (char)0x9a,
                (char)0x75, (char)0x54, (char)0x37, (char)0x16, (char)0xf1, (char)0xd0, (char)0xb3, (char)0x92,
                (char)0x2e, (char)0x0f, (char)0x6c, (char)0x4d, (char)0xaa, (char)0x8b, (char)0xe8, (char)0xc9,
                (char)0x26, (char)0x07, (char)0x64, (char)0x45, (char)0xa2, (char)0x83, (char)0xe0, (char)0xc1,
                (char)0x1f, (char)0x3e, (char)0x5d, (char)0x7c, (char)0x9b, (char)0xba, (char)0xd9, (char)0xf8,
                (char)0x17, (char)0x36, (char)0x55, (char)0x74, (char)0x93, (char)0xb2, (char)0xd1, (char)0xf0
        };
/*
    public static UInt16 GetCRC16(byte[] data)
    {
        return GetCRC16(data, 0, data.Length);
    }*/

    public static int GetCRC16(char[] data, int startIndex, int length)
    {
        char nCRCHi = 0xFF;
        char nCRCLo = 0xFF;
        char nIndex;
        //while(nData>0)
        for (int i = startIndex, count = 0; count < length; i++, count++)
        {

            //nIndex = nCRCHi ^ *pData++;
            nIndex = (char)(nCRCHi ^ data[i]);

            nCRCHi = (char)(nCRCLo ^ auchCRC16Hi[nIndex]);
            nCRCLo = auchCRC16Lo[nIndex];
        }
       // return (int)(nCRCHi << 8 | nCRCLo);
        return (int)(nCRCHi << 8 | (nCRCLo >> 8));
    }

    public static int calcCrc16(char[] data, int offset, int len) {
        return calcCrc16(data, offset, len, 0xffff);
    }

    /**
     * 计算CRC16校验
     *
     * @param data
     *            需要计算的数组
     * @param offset
     *            起始位置
     * @param len
     *            长度
     * @param preval
     *            之前的校验值
     * @return CRC16校验值
     */
    public static int calcCrc16(char[] data, int offset, int len, int preval) {
        int ucCRCHi = (preval & 0xff00) >> 8;
        int ucCRCLo = preval & 0x00ff;
        int iIndex;
        for (int i = 0; i < len; ++i) {
            iIndex = (ucCRCLo ^ data[offset + i]) & 0x00ff;
            ucCRCLo = ucCRCHi ^ auchCRC16Hi[iIndex];
            ucCRCHi = auchCRC16Lo[iIndex];
        }
        //System.out.println("高位 地位");
        //System.out.println(ucCRCHi);
        //System.out.println(ucCRCLo);
        return ((ucCRCHi & 0x00ff) << 8) | (ucCRCLo & 0x00ff) & 0xffff;
    }
   
    public static char[] hexStringToByteArray(String s) {
    	s = s.trim();
        s = s.replace(" ", "");
        s = s.replace("x", "");
        s = s.replace("X", "");
        
        char[] b = new char[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
          int index = i * 2;
          int v = Integer.parseInt(s.substring(index, index + 2), 16);
          b[i] = (char) v;
        }
        return b;
      }

    public static byte[] IntToByteArray(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }

    public static void main(String[] args) {
		String data = "7E 45 00 01 08 00 79 B0 0E 49 00 6F 01 3D 21 1F F4 3C 21 1F F4 3C 89 2D";//
        //String data = "7E 45 00 01 08 00 00 6F 01 3D 21 1F F4 3C 00 00";
		char data_byte[] = hexStringToByteArray(data);
		for(char c:data_byte){
			//System.out.println(Integer.valueOf(c));
		}
		int crcData = calcCrc16(data_byte,0,data_byte.length - 2);
        char value=(char)crcData;
		System.out.println(Integer.valueOf(crcData));
        System.out.println(Integer.toHexString(crcData).toString());
        System.out.println();
        StringBuilder stringBuilder=new StringBuilder(4);
        for(byte byteChar:IntToByteArray(2597)){
            stringBuilder.append(String.format("%02X", byteChar));
            //System.out.println(Integer.valueOf(c));
        }
        System.out.println(stringBuilder.toString());

        CRC16 crc = new CRC16();
        // aa 01 d0 08 7e 0f 00 00 00 3f 0d bb
        // aa 01 d0 04 7d de 70 bb
        // int[] test = { 0x01, 0xd0, 0x08, 0x7e, 0x0f, 0x00, 0x00, 0x00};
        // aa 01 d0 04 7c ff 60 bb
        data = "7E 45 80 01 00 00";
        byte[] test = BluetoothUtil.hex2Bytes(data);
        char ch = crc.caluCRC(test);
        // 以下是为了测试方便进行的处理，因为char数据类型很多是不可显示的
        int i = (int) ch;
        String str = Integer.toHexString(i);
        System.out.println("CRC十六进制字符串是:" + str);
        System.out.println("CRC整数类型的数据是:" + i);
        System.out.println(getTHECRC16(data));

    }

    public static String getTHECRC16(String str) {
        byte[] test = BluetoothUtil.hex2Bytes(str);
        char ch = caluCRC(test);
        int i = (int) ch;
        String str_crc16 = Integer.toHexString(i);
        int cu_length=4-str_crc16.length();
        //4\3\2\1
        if (cu_length>0&&cu_length<=4) {
            for (int j = 0; j <cu_length; j++) {
                str_crc16="0"+str_crc16;
            }
        }
        System.out.println("CRC十六进制字符串是:" + str_crc16);
        return str_crc16;
    }

    private static char[] crc_tb = { 0x0000, 0x1021, 0x2042, 0x3063, 0x4084, 0x50a5, 0x60c6, 0x70e7, 0x8108, 0x9129, 0xa14a, 0xb16b, 0xc18c, 0xd1ad, 0xe1ce,
            0xf1ef, 0x1231, 0x0210, 0x3273, 0x2252, 0x52b5, 0x4294, 0x72f7, 0x62d6, 0x9339, 0x8318, 0xb37b, 0xa35a, 0xd3bd, 0xc39c, 0xf3ff, 0xe3de,
            0x2462, 0x3443, 0x0420, 0x1401, 0x64e6, 0x74c7, 0x44a4, 0x5485, 0xa56a, 0xb54b, 0x8528, 0x9509, 0xe5ee, 0xf5cf, 0xc5ac, 0xd58d, 0x3653,
            0x2672, 0x1611, 0x0630, 0x76d7, 0x66f6, 0x5695, 0x46b4, 0xb75b, 0xa77a, 0x9719, 0x8738, 0xf7df, 0xe7fe, 0xd79d, 0xc7bc, 0x48c4, 0x58e5,
            0x6886, 0x78a7, 0x0840, 0x1861, 0x2802, 0x3823, 0xc9cc, 0xd9ed, 0xe98e, 0xf9af, 0x8948, 0x9969, 0xa90a, 0xb92b, 0x5af5, 0x4ad4, 0x7ab7,
            0x6a96, 0x1a71, 0x0a50, 0x3a33, 0x2a12, 0xdbfd, 0xcbdc, 0xfbbf, 0xeb9e, 0x9b79, 0x8b58, 0xbb3b, 0xab1a, 0x6ca6, 0x7c87, 0x4ce4, 0x5cc5,
            0x2c22, 0x3c03, 0x0c60, 0x1c41, 0xedae, 0xfd8f, 0xcdec, 0xddcd, 0xad2a, 0xbd0b, 0x8d68, 0x9d49, 0x7e97, 0x6eb6, 0x5ed5, 0x4ef4, 0x3e13,
            0x2e32, 0x1e51, 0x0e70, 0xff9f, 0xefbe, 0xdfdd, 0xcffc, 0xbf1b, 0xaf3a, 0x9f59, 0x8f78, 0x9188, 0x81a9, 0xb1ca, 0xa1eb, 0xd10c, 0xc12d,
            0xf14e, 0xe16f, 0x1080, 0x00a1, 0x30c2, 0x20e3, 0x5004, 0x4025, 0x7046, 0x6067, 0x83b9, 0x9398, 0xa3fb, 0xb3da, 0xc33d, 0xd31c, 0xe37f,
            0xf35e, 0x02b1, 0x1290, 0x22f3, 0x32d2, 0x4235, 0x5214, 0x6277, 0x7256, 0xb5ea, 0xa5cb, 0x95a8, 0x8589, 0xf56e, 0xe54f, 0xd52c, 0xc50d,
            0x34e2, 0x24c3, 0x14a0, 0x0481, 0x7466, 0x6447, 0x5424, 0x4405, 0xa7db, 0xb7fa, 0x8799, 0x97b8, 0xe75f, 0xf77e, 0xc71d, 0xd73c, 0x26d3,
            0x36f2, 0x0691, 0x16b0, 0x6657, 0x7676, 0x4615, 0x5634, 0xd94c, 0xc96d, 0xf90e, 0xe92f, 0x99c8, 0x89e9, 0xb98a, 0xa9ab, 0x5844, 0x4865,
            0x7806, 0x6827, 0x18c0, 0x08e1, 0x3882, 0x28a3, 0xcb7d, 0xdb5c, 0xeb3f, 0xfb1e, 0x8bf9, 0x9bd8, 0xabbb, 0xbb9a, 0x4a75, 0x5a54, 0x6a37,
            0x7a16, 0x0af1, 0x1ad0, 0x2ab3, 0x3a92, 0xfd2e, 0xed0f, 0xdd6c, 0xcd4d, 0xbdaa, 0xad8b, 0x9de8, 0x8dc9, 0x7c26, 0x6c07, 0x5c64, 0x4c45,
            0x3ca2, 0x2c83, 0x1ce0, 0x0cc1, 0xef1f, 0xff3e, 0xcf5d, 0xdf7c, 0xaf9b, 0xbfba, 0x8fd9, 0x9ff8, 0x6e17, 0x7e36, 0x4e55, 0x5e74, 0x2e93,
            0x3eb2, 0x0ed1, 0x1ef0 };

    public static char caluCRC(byte[] pByte) {
        int len = pByte.length;
        char crc;
        byte da;
        crc = 0x0;
        int i = 0;
        while (len-- != 0) {
            da = (byte) (crc / 256);
            crc <<= 8;
            int num = da ^ pByte[i];
            //System.out.println("the num is: " + num);
            if (num < 0)
                num += 256;
            crc ^= crc_tb[num];
            ++i;
        }
        return crc;
    }



}
