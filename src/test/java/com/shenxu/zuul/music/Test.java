package com.shenxu.zuul.music;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

public class Test {

    public static void main(String[] args) {

        String song1 = "C:/Users/ly/Desktop/林俊杰 - 可惜没如果.wav";
        String recordedClip = "C:/Users/ly/Desktop/林俊杰 - 可惜没如果.wav";

        Wave wave1 = new Wave(song1);
        Wave waveRec = new Wave(recordedClip);

        FingerprintSimilarity similarity = wave1.getFingerprintSimilarity(waveRec);
        System.out.println("clip is found at " + similarity.getsetMostSimilarTimePosition() + "s in " + wave1 +
                " with similarity " + similarity.getSimilarity());


//        clip is found at 66.2s in chunkId: RIFF
//        chunkSize: 12217420
//        format: WAVE
//        subChunk1Id: fmt
//        subChunk1Size: 16
//        audioFormat: 1
//        channels: 2
//        sampleRate: 10240
//        byteRate: 20480
//        blockAlign: 4
//        bitsPerSample: 16
//        subChunk2Id: data
//        subChunk2Size: 12217384
//        length: 9:56.55194 with similarity 0.020386936
    }

}
