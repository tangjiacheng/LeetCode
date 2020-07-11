package com.utils;

import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/7/2 13:00
 * @description: TODO
 */
public class TrieNode {
    char ch;
    int freqs;
    Map<Character, TrieNode> nodeMap;

    public TrieNode(char ch, int freqs, Map<Character, TrieNode> nodeMap) {
        this.ch = ch;
        this.freqs = freqs;
        this.nodeMap = nodeMap;
    }
}
