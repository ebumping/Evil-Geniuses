package sideWork;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class RandomCode {
	public static void main(String[] args) {        
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();           
	}
	

}