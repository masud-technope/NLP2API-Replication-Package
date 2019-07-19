package com.javacodegeeks.snippets.desktop;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

public class PlayMidiAudio {

	public static void main(String[] args) throws Exception {

		// Obtains the default Sequencer connected to a default device.
		Sequencer sequencer = MidiSystem.getSequencer();

		// Opens the device, indicating that it should now acquire any
	    // system resources it requires and become operational.
		sequencer.open();

	    // create a stream from a file
	    InputStream is = new BufferedInputStream(new FileInputStream(new File("midifile.mid")));

	    // Sets the current sequence on which the sequencer operates.
	    // The stream must point to MIDI file data.
	    sequencer.setSequence(is);

	    // Starts playback of the MIDI data in the currently loaded sequence.
	    sequencer.start();

	}

}