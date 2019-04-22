package Model;

import java.util.Random;
import java.util.Stack;

public class Maze {
	int block[][]={
			{1,1,1,1,1,1,1,1,1,1},
			{1,0,0,1,0,0,0,1,2,1},
			{1,0,0,1,1,1,0,1,0,1},
			{1,1,0,1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1,0,1,1},
			{1,0,0,1,1,0,1,0,1,1},
			{1,0,1,0,0,0,1,1,0,1},
			{1,0,1,0,1,0,0,0,0,1},
			{1,0,1,0,1,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1}
		};
	int blocks[][]=new int[10][10];
	block site=new block(1,1);
	Stack<block> trace=new Stack<block>();
	int a,b;//交换地址用
	
	void run() {
		for(int i=0;i<4;i++){
			reset(i);
			if(block[a][b]==0||block[a][b]==2) {
				block[site.x][site.y]=1;
				site.x=a;site.y=b;
				trace.push(new block(a,b));
				break;
			}
			if(i==3) {block[site.x][site.y]=1;site=trace.pop();return;}//如果哪里都不能走，退出。 
		}
	}
	void reset(int i){
		switch(i){
			case 0:a=site.x-1;b=site.y;break;
			case 1:a=site.x+1;b=site.y;break;
			case 2:a=site.x;b=site.y-1;break;
			case 3:a=site.x;b=site.y+1;break;
		}
	}
	
	public int getNum(int i) {
		if(i==site.x*10+site.y) return 3;
		return blocks[i/10][i%10];
	}
	public boolean check(){
		if(block[site.x][site.y]==2) return false;
		return true;
	}
	public Maze() {
		for(int i=0;i<block.length;i++)
			System.arraycopy(block[i], 0, blocks[i], 0, block[i].length);
	}
}

class block{
	public int x,y;
	public block(int x,int y) {
		this.x=x;
		this.y=y;
	}
}