package com.javacodegeeks.snippets.desktop;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.midi.MidiFileFormat;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

public class GetMidiAudioFileProperties {

	public static void main(String[] args) throws Exception {

		// Obtains the default Sequencer connected to a default device.
		Sequencer sequencer = MidiSystem.getSequencer();

	    // create a stream from a file
	    InputStream is = new BufferedInputStream(new FileInputStream(new File("midifile.mid")));

	    // Obtain the MIDI file format of the data in the specified input stream.
	    MidiFileFormat fformat = MidiSystem.getMidiFileFormat(is);

	    // Obtain the MIDI file type.
		switch (fformat.getType()) {
			case 0:
				System.out.println("mid file format");
				break;
			case 1:
				System.out.println("rmf file format");
				break;
		}

	    // Sets the current sequence on which the sequencer operates.
	    // The stream must point to MIDI file data.
	    sequencer.setSequence(is);

	    // Obtains the length of the current sequence, expressed in microseconds
	    long durationMicroSecs = sequencer.getMicrosecondLength();
	    long durationSecs = durationMicroSecs/1000000;

	    System.out.println("durationInSecs " + durationSecs);

	}

}