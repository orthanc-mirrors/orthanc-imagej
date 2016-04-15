/**
 * Orthanc - A Lightweight, RESTful DICOM Store
 * Copyright (C) 2012-2016 Sebastien Jodogne, Medical Physics
 * Department, University Hospital of Liege, Belgium
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 **/


package com.orthancserver;

import ij.plugin.PlugIn;
import ij.Prefs;
import javax.swing.JOptionPane;

public class Orthanc implements PlugIn 
{
  public void run(String arg) 
  {
    SelectImageDialog d = new SelectImageDialog();
    d.Unserialize(Prefs.get("orthanc.servers", ""));

    boolean success = d.ShowModal();
    Prefs.set("orthanc.servers", d.Serialize());  

    if (success)
    {
      try 
      {
        DicomDecoder decoder = new DicomDecoder(d.GetSelectedConnection(), d.IsInstanceSelected(), d.GetSelectedUuid());
        decoder.GetImage().show();
      }
      catch (Exception e) 
      {
        JOptionPane.showMessageDialog(null, "Error while importing this image: " + e.getMessage());
        //e.printStackTrace(System.out);
      }
    }
  }


  // To execute the "main()" method on Ubuntu 14.04 (with ImageJ installed):
  // java -classpath Orthanc_Import.jar:/usr/share/java/ij.jar com.orthancserver.Orthanc

  public static void main(String[] args)
  {
    try
    {
      OrthancConnection c = new OrthancConnection();
      java.awt.image.BufferedImage i = c.ReadImage("/instances/51a7cbee-0863938e-6198f621-17611be4-a2767489/preview");
    }
    catch (Exception e)
    {
      System.out.println("EXCEPTION:");
      e.printStackTrace();
    }
  }
}
