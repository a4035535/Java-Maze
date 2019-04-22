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
	//set two block,first as the maze,the other for player to remember.
	//the '0' will be show as the white ground.'1' will be show as wall.'2' is the gold, also the goal.
	//in fact you can change the array to any shape you like,the DFS can still run.
	block site=new block(1,1);
	//the starting point.
	Stack<block> trace=new Stack<block>();//a stack to record the site.
	
	int a,b;//use to change the dir.
	
	//find way to go.
	void run() {
		for(int i=0;i<4;i++){
			reset(i);
			if(block[a][b]==0||block[a][b]==2) {
				block[site.x][site.y]=1;
				site.x=a;site.y=b;
				trace.push(new block(a,b));
				break;
			}
			if(i==3) {block[site.x][site.y]=1;site=trace.pop();return;}//if can't run,go back.
		}
	}
	//change site by 'i' which stand for the dirction.
	void reset(int i){
		switch(i){
			case 0:a=site.x-1;b=site.y;break;
			case 1:a=site.x+1;b=site.y;break;
			case 2:a=site.x;b=site.y-1;break;
			case 3:a=site.x;b=site.y+1;break;
		}
	}
	//get the 'thing' around site.
	public int getNum(int i) {
		if(i==site.x*10+site.y) return 3;
		return blocks[i/10][i%10];
	}
	//check is the player go to end.
	public boolean check(){
		if(block[site.x][site.y]==2) return false;
		return true;
	}
	//initialization
	public Maze() {
		for(int i=0;i<block.length;i++)
			System.arraycopy(block[i], 0, blocks[i], 0, block[i].length);
	}
}
//a two-dimensional class to stand for point.
class block{
	public int x,y;
	public block(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
