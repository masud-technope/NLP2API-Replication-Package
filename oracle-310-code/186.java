/*  w w w  .jav a  2  s  .  co  m*/
//  Ahy - A pure java CMS.
//  Copyright (C) 2010 Sidney Leal (manish.com.br)
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//package br.com.manish.ahy.fxadmin;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main {

        public static byte[] readFileAsBytes(String path, Integer start, Integer length) {

        byte[] byteData = null;

        try {

            File file = new File(path);

            DataInputStream dis;
            dis = new DataInputStream(new FileInputStream(file));

            if (dis.available() > Integer.MAX_VALUE) {
              System.out.println("dis.available() > Integer.MAX_VALUE");
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream(length);
            byte[] bytes = new byte[length];

            dis.skipBytes(start);
            int readBytes = dis.read(bytes, 0, length);
            os.write(bytes, 0, readBytes);
            
            byteData = os.toByteArray();

            dis.close();
            os.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return byteData;
    }

}
