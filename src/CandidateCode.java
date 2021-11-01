
import java.util.ArrayList;

import java.util.Scanner;
public class CandidateCode {
    ArrayList<path>data1;
	ArrayList<visit>data2;
	Scanner sc;
	int n,m,i,large=0,j;
	int[] value ,notmatch;
	
	public CandidateCode() 
	{
		data1= new ArrayList<path>();
		data2= new ArrayList<visit>();
		sc=new Scanner(System.in);
	}
	class visit
	{
		protected int start,end;
		public void setstart(int start)
		{
			this.start=start;
		}
		public int getstart()
		{
			return this.start;
		}
	
		public void setend(int end)
		{
			this.end=end;
		}
		public int getend()
		{
			return end;
		}
	}
	class path
	{
		protected int u,v;
		public void setu(int u)
		{
			this.u=u;
		}
		public int getu()
		{
			return this.u;
		}
	
		public void setv(int v)
		{
			this.v=v;
		}
		public int getv()
		{
			return v;
		}
	}
	
	public int ending(int end,int arg)
	{
		int s;
		notmatch[arg-1]=1;
		if(end==arg)
	    {
	        ++value[arg-1];
	        return 1;
	    }
		else
		{
			for(s=0;s<(n-1);s++)
	        {	
				path a=(path)data1.get(s);
				if((int)a.getu()==arg && notmatch[(int)a.getv()-1]==0)
	            {
	                if(ending(end,(int)a.getv())>0)
	                {
	                    ++value[arg-1];
	                    return 1;
	                }
	            }
	            else if((int)a.getv()==arg && notmatch[(int)a.getu()-1]==0)
	            {
	                if(ending(end,(int)a.getu())>0)
	                {
	                	++value[arg-1];
	                     return 1;
	                }
	            }
	        }
		}
		return 0;
	}
	
	public void beg(visit v)
	{
		int k;
		++value[(int)v.getstart()-1];
		for(k=0;k<(n-1);k++)
		{
			path a=(path)data1.get(k);
			if((int)v.getstart()==(int)a.getu() && notmatch[(int)a.getv()-1]==0)
			{
				if(ending((int)v.getend(),(int)a.getv())>0)
				{
					return;
				}
			}
			else if((int)v.getstart()==(int)a.getv() && notmatch[(int)a.getu()-1]==0)
			{
				if(ending((int)v.getend(),(int)a.getu())>0)
				{
					return;
				}
			}
		}
	}
	public void accept()
	{
	

		n=sc.nextInt();

		m=sc.nextInt();
		value=new int[n];
		
		notmatch=new int[n];
	
		if(n==1)
		{
			path paths=new path () ;
			paths.setu(sc.nextInt());
		}
		else
		{
			for(i=0;i<(n-1);i++)
			{
				path paths=new path () ;
				paths.setu(sc.nextInt());
				paths.setv(sc.nextInt());
				data1.add(paths);
			}
			
		}
		for(i=0;i<m;i++)
		{
			visit visits=new visit() ;
			visits.setstart(sc.nextInt());
			visits.setend(sc.nextInt());
			data2.add(visits);
		}
		
		for(i=0;i<m;i++)
		{
			notmatch=new int[n];
			visit a=(visit)data2.get(i);
			notmatch[(int)a.getstart()-1]=1;
			beg(a);
		}
	
		for(i=0;i<n;i++)
		{
			if(large<value[i])
	        {
	            large=value[i];
	        }
		}
		System.out.println(large);
		
	}
    
    public static void main(String args[] )  {
    CandidateCode obj=new CandidateCode();
		obj.accept();

   }
}

