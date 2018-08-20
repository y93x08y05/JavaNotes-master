package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/17/2018.
 * 给定整数n和m, 将1到n的这n个整数按字典序排列之后, 求其中的第m个数。
 * 对于n=11, m=4, 按字典序排列依次为1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 因此第4个数是2.
 * 对于n=200, m=25, 按字典序排列依次为1 10 100 101 102 103 104 105 106 107 108 109 11
 * 110 111 112 113 114 115 116 117 118 119 12 120 121 122 123 124 125 126 127 128
 * 129 13 130 131 132 133 134 135 136 137 138 139 14 140 141 142 143 144 145 146
 * 147 148 149 15 150 151 152 153 154 155 156 157 158 159 16 160 161 162 163 164
 * 165 166 167 168 169 17 170 171 172 173 174 175 176 177 178 179 18 180 181 182
 * 183 184 185 186 187 188 189 19 190 191 192 193 194 195 196 197 198 199 2 20
 * 200 21 22 23 24 25 26 27 28 29 3 30 31 32 33 34 35 36 37 38 39 4 40 41 42 43
 * 44 45 46 47 48 49 5 50 51 52 53 54 55 56 57 58 59 6 60 61 62 63 64 65 66 67
 * 68 69 7 70 71 72 73 74 75 76 77 78 79 8 80 81 82 83 84 85 86 87 88 89 9 90
 * 91 92 93 94 95 96 97 98 99 因此第25个数是120…
 * 输入仅包含两个整数n和m
 * 数据范围:
 * 对于20%的数据, 1 <= m <= n <= 5 ;
 * 对于80%的数据, 1 <= m <= n <= 10^7 ;
 * 对于100%的数据, 1 <= m <= n <= 10^18.
 * 输出仅包括一行, 即所求排列中的第m个数字.
 */
public class dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while((line=bf.readLine())!=null)
        {
            String []s=line.split(" ");
            long n = Long.parseLong(s[0]);
            long m = Long.parseLong(s[1]);
            System.out.println(solve(n,m));
        }
    }
    private static long solve(long n, long m) {
        long ans=1;//默认
        while(m!=0) {
            long cnt=help(ans,n);
            if(cnt>=m) {
                m--;
                if(m==0)
                    break;
                ans*=10;
            }else {
                m-=cnt;
                ans++;
            }
        }
        return ans;
    }
    private static long help(long ans, long n) {
        long cnt=1;
        long p=10;
        for(;ans*p<=n;p*=10) {
            if(ans*p+p-1<n) {
                cnt+=p;
            } else {
                cnt+=(n-ans*p+1);
            }
        }
        return cnt;//计数
    }
}
