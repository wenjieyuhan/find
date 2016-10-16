import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Tool {
	static int TRUE = 0;
	static int FALSE = 1;
	public static int generat_test_num(GenerateType type, int pivot, boolean isRight){
		Random random = new Random();
		switch(type){
		case EQUAL:
			if(isRight){
				return pivot;
			}else{
				return pivot + (random.nextInt(10) + 1) * (random.nextInt(10) % 2 == 0 ? 1 : -1);
			}
		case LARGE: 
			if(isRight){
				return pivot + random.nextInt(10) + 1;
			}else{
				return pivot - random.nextInt(10);
			}
		case LARGE_EQUEAL: 
			
			if(isRight){
				return pivot + random.nextInt(10);
			}else{
				return pivot - random.nextInt(10) -1;
			}
			
		case LESS_EQUAL:
			if(isRight){
				return pivot - random.nextInt(10);
			}else{
				return pivot + random.nextInt(10) +1;
			}
		case LESS:
			if(isRight){
				return pivot - random.nextInt(10) -1;
			}else{
				return pivot + random.nextInt(10);
			}
		default :
			break;
		}
		return 0;
	}
	
	public static int[] generate_test_num_list(ArrayList<GenerateType> GenerateType_list, ArrayList<Integer> num_list ,boolean[] list){
		int[] alist = new int[list.length];
		for(int i = 0; i < list.length; i++){
			alist[i] = (generat_test_num(GenerateType_list.get(i),num_list.get(i),list[i]));
		}
		return alist;
	}
	
	public static int[][] generate_test_num_list_array(ArrayList<GenerateType> GenerateType_list, ArrayList<Integer> num_list,boolean[][] list){
		int[][] alist = new int[list.length][];
		for(int i =0; i < list.length; i++){
			alist[i] = generate_test_num_list(GenerateType_list, num_list, list[i]);
		}
		return alist;
	}
	public static boolean compare(int a, int b,GenerateType generateType){
		
		switch(generateType){
		case EQUAL:
			return (a == b);
		case LARGE: 
			return ( a > b );
		case LARGE_EQUEAL: 
			return ( a >= b );
		case LESS_EQUAL:
			return ( a <= b );
		case LESS:
			return ( a < b );
		default :
			return false;
		}
		
	}
	
	
	public static boolean[][] getArrayByAndOrAnd(int type){
		boolean T = true;
		boolean F = false;
		
		
		if(type == 0){
			boolean[][] s = new boolean[7][];
			s[0] = new boolean[]{T,T,F,F};
			s[1] = new boolean[]{T,T,F,T};
			s[2] = new boolean[]{T,T,T,F};
			s[3] = new boolean[]{T,T,T,T};
			s[4] = new boolean[]{T,F,T,T};
			s[5] = new boolean[]{F,T,T,T};
			s[6] = new boolean[]{F,F,T,T};

			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[9][];
			s[0] = new boolean[]{T,F,T,F};
			s[1] = new boolean[]{T,F,F,T};
			s[2] = new boolean[]{T,F,F,F};
			s[3] = new boolean[]{F,T,F,T};
			s[4] = new boolean[]{F,T,T,F};
			s[5] = new boolean[]{F,T,F,F};
			s[6] = new boolean[]{F,F,T,F};
			s[7] = new boolean[]{F,F,F,T};
			s[8] = new boolean[]{F,F,F,F};
			return s;
		}else{
			boolean[][] s = new boolean[16][];
			s[0] = new boolean[]{T,T,F,F};
			s[1] = new boolean[]{T,T,F,T};
			s[2] = new boolean[]{T,T,T,F};
			s[3] = new boolean[]{T,T,T,T};
			s[4] = new boolean[]{T,F,T,T};
			s[5] = new boolean[]{F,T,T,T};
			s[6] = new boolean[]{F,F,T,T};
			s[7] = new boolean[]{T,F,T,F};
			s[8] = new boolean[]{T,F,F,T};
			s[9] = new boolean[]{T,F,F,F};
			s[10] = new boolean[]{F,T,F,T};
			s[11] = new boolean[]{F,T,T,F};
			s[12] = new boolean[]{F,T,F,F};
			s[13] = new boolean[]{F,F,T,F};
			s[14] = new boolean[]{F,F,F,T};
			s[15] = new boolean[]{F,F,F,F};
			return s;
		}
	}
	public static boolean[][] getArrayByAndOrAnd_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByAndOrAnd(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;
	}	
	
	// 0 true 1 false 2 all
	public static boolean[][] getArrayByAndOR(int type){
		boolean T = true;
		boolean F = false;
		
		
		if(type == 0){
			boolean[][] s = new boolean[5][];
			s[0] = new boolean[]{T,T,F};
			s[1] = new boolean[]{T,T,T};
			s[2] = new boolean[]{F,F,T};
			s[3] = new boolean[]{T,F,T};
			s[4] = new boolean[]{F,T,T};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[3][];
			s[0] = new boolean[]{F,F,F};
			s[1] = new boolean[]{T,F,F};
			s[2] = new boolean[]{T,T,F};
			return s;
		}else{
			boolean[][] s = new boolean[8][];
			s[0] = new boolean[]{T,T,T};
			s[1] = new boolean[]{T,T,F};
			s[2] = new boolean[]{T,F,T};
			s[3] = new boolean[]{F,T,T};
			s[4] = new boolean[]{T,F,F};
			s[5] = new boolean[]{F,F,T};
			s[6] = new boolean[]{F,T,F};
			s[7] = new boolean[]{F,F,F};
			return s;
		}		
	}
	
	public static boolean[][] getArrayByAndOR_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByAndOR(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;
	}
	
	public static boolean[][] getArrayByAndAnd(int type){
		boolean T = true;
		boolean F = false;
		
		if(type == 0){
			boolean[][] s = new boolean[1][];
			s[0] = new boolean[]{T,T,T};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[7][];
			s[0] = new boolean[]{F,F,F};
			s[1] = new boolean[]{T,T,F};
			s[2] = new boolean[]{T,F,T};
			s[3] = new boolean[]{F,T,T};
			s[4] = new boolean[]{T,F,F};
			s[5] = new boolean[]{F,F,T};
			s[6] = new boolean[]{F,T,F};
			return s;
		}else{
			boolean[][] s = new boolean[8][];
			s[0] = new boolean[]{T,T,T};
			s[1] = new boolean[]{T,T,F};
			s[2] = new boolean[]{T,F,T};
			s[3] = new boolean[]{F,T,T};
			s[4] = new boolean[]{T,F,F};
			s[5] = new boolean[]{F,F,T};
			s[6] = new boolean[]{F,T,F};
			s[7] = new boolean[]{F,F,F};
			return s;
		}		
	}
	
	public static boolean[][] getArrayByAndAnd_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByAndAnd(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;	
	}
	
	public static boolean[][] getArrayByOrAnd(int type){
		boolean T = true;
		boolean F = false;
		
		if(type == 0){
			boolean[][] s = new boolean[5][];
			s[0] = new boolean[]{T,T,F};
			s[1] = new boolean[]{T,F,T};
			s[2] = new boolean[]{T,T,T};
			s[3] = new boolean[]{T,F,F};
			s[4] = new boolean[]{F,T,T};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[3][];
			s[0] = new boolean[]{F,F,F};
			s[0] = new boolean[]{F,T,F};
			s[0] = new boolean[]{F,F,T};
			return s;
		}else{
			boolean[][] s = new boolean[8][];
			s[0] = new boolean[]{T,T,T};
			s[1] = new boolean[]{T,T,F};
			s[2] = new boolean[]{T,F,T};
			s[3] = new boolean[]{F,T,T};
			s[4] = new boolean[]{T,F,F};
			s[5] = new boolean[]{F,F,T};
			s[6] = new boolean[]{F,T,F};
			s[7] = new boolean[]{F,F,F};
			return s;
		}
		
	}
	
	public static boolean[][] getArrayByOrAnd_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByOrAnd(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;	
	}
	
	public static boolean[][] getArrayByOrOr(int type){
		boolean T = true;
		boolean F = false;
		
		if(type == 0){
			boolean[][] s = new boolean[7][];
			s[0] = new boolean[]{T,T,T};
			s[1] = new boolean[]{T,T,F};
			s[2] = new boolean[]{T,F,T};
			s[3] = new boolean[]{F,T,T};
			s[4] = new boolean[]{T,F,F};
			s[5] = new boolean[]{F,F,T};
			s[6] = new boolean[]{F,T,F};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[1][];
			s[0] = new boolean[]{F,F,F};
			return s;
		}else{
			boolean[][] s = new boolean[8][];
			s[0] = new boolean[]{T,T,T};
			s[1] = new boolean[]{T,T,F};
			s[2] = new boolean[]{T,F,T};
			s[3] = new boolean[]{F,T,T};
			s[4] = new boolean[]{T,F,F};
			s[5] = new boolean[]{F,F,T};
			s[6] = new boolean[]{F,T,F};
			s[7] = new boolean[]{F,F,F};
			return s;
		}	
	}
	
	public static boolean[][] getArrayByOrOr_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByOrOr(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;
	}
	//
	
	public static boolean[][] getArrayByAnd(int type){
		boolean T = true;
		boolean F = false;
		
		if(type == 0){
			boolean[][] s = new boolean[1][];
			s[0] = new boolean[]{T,T};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[3][];
			s[0] = new boolean[]{F,F};
			s[1] = new boolean[]{T,F};
			s[2] = new boolean[]{F,T};
			return s;
		}else{
			boolean[][] s = new boolean[4][];
			s[0] = new boolean[]{T,F};
			s[1] = new boolean[]{T,T};
			s[2] = new boolean[]{F,T};
			s[3] = new boolean[]{F,F};
			return s;
		}			
	}
	
	public static boolean[][] getArrayByAnd_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByAnd(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;			
	}
	
	public static boolean[][] getArrayByOr(int type){
		boolean T = true;
		boolean F = false;
		
		if(type == 0){
			boolean[][] s = new boolean[1][];
			s[0] = new boolean[]{T,T};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[3][];
			s[0] = new boolean[]{F,F};
			s[1] = new boolean[]{T,F};
			s[2] = new boolean[]{F,T};
			return s;
		}else{
			boolean[][] s = new boolean[4][];
			s[0] = new boolean[]{T,F};
			s[1] = new boolean[]{T,T};
			s[2] = new boolean[]{F,T};
			s[3] = new boolean[]{F,F};
			return s;
		}		
	}
	
	public static boolean[][] getArrayByOr_RANDOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArrayByOr(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;		
	}
	
	public  static boolean[][] getArray(int type){
		boolean T = true;
		boolean F = false;
		
		if(type == 0){
			boolean[][] s = new boolean[1][];
			s[0] = new boolean[]{T};
			return s;
		}else if(type == 1){
			boolean[][] s = new boolean[1][];
			s[0] = new boolean[]{F};
			return s;
		}else{
			boolean[][] s = new boolean[2][];
			s[0] = new boolean[]{T};
			s[1] = new boolean[]{F};
			return s;
		}
	}
	
	public  static boolean[][] getArray_RANOM_ONE(int type){
		boolean[][] s = new boolean[1][];
		Random random = new Random();
		boolean[][] arr = getArray(type);
		s[0] = arr[random.nextInt(arr.length)];
		return s;	
	}
	
	public static boolean[][] Connect(boolean[][] x, boolean[][] y ){
		boolean T = true;
		boolean F = false;
		int len = x.length > y.length ? y.length : x.length;
		int max_len = x.length > y.length ? x.length : y.length;
		boolean[][] s = new boolean[max_len][];
		
		int i = 0;
		for(; i < len; i++){
			s[i] = new boolean[x[i].length+ y[i].length];
			System.arraycopy(x[i], 0, s[i], 0, x[i].length);  
			System.arraycopy(y[i], 0, s[i], x[i].length, y[i].length);  
		}
		
		if(x.length > y.length){
			for(int j = i; j < x.length; j++){
				s[j] = new boolean[x[0].length+ y[0].length];
				System.arraycopy(x[j], 0, s[j], 0, x[j].length);
				Random random = new Random();
				int rand_num = random.nextInt(y.length);
				System.arraycopy(y[rand_num], 0, s[j], x[j].length, y[rand_num].length);  				
			}
		}else if(x.length < y.length){
			for(int j = i; j < y.length; j++){
				
				Random random = new Random();
				int rand_num = random.nextInt(x.length);
				s[j] = new boolean[x[0].length+ y[0].length];
				System.arraycopy(x[rand_num], 0, s[j], 0, x[rand_num].length);
				System.arraycopy(y[j], 0, s[j], x[rand_num].length, y[j].length);
				
			}			
		}
		return s;
	}
	
	public static boolean[][] Connect(boolean[][][]s){
		if(s.length < 1){
			return null;
		}
		boolean[][] tmp = s[0];
		for(int i = 1; i < s.length; i++){
			tmp = Connect(tmp,s[i]);
		}
		return tmp;
	}
	
	public static boolean[][] Cross_Join(boolean[][] x, boolean[][] y ){
		boolean T = true;
		boolean F = false;
		int max_len =x.length * y.length;
//		System.out.println("max_len:"+max_len);
		boolean[][] s = new boolean[max_len][];
		
		int counter = 0;
		for(int i = 0; i < x.length; i++){
			for(int j = 0; j < y.length; j++){
//				System.out.println("counter:"+counter+" x.length:"+x.length+" y.length:"+
//			y.length+" s.length "+s.length+"("+i+"..."+j+")");
				
				s[counter] = new boolean[x[i].length + y[j].length];
				
				System.arraycopy(x[i], 0, s[counter], 0, x[i].length);  
				System.arraycopy(y[j], 0, s[counter], x[i].length, y[j].length);  
				counter++;
			}
		}
		return s;
	}
	
	public static boolean[][] Cross_Join(boolean[][][]s){
		if(s.length < 1){
			return null;
		}
		boolean[][] tmp = s[0];
		for(int i = 1; i < s.length; i++){
			tmp = Cross_Join(tmp,s[i]);
		}
		return tmp;
	}
	

	
	public static boolean[][] Add(boolean[][] x, boolean[][] y){
		boolean T = true;
		boolean F = false;
		int max_len =x.length + y.length;
		boolean[][] s = new boolean[max_len][];
		System.arraycopy(x, 0, s, 0, x.length);  
		System.arraycopy(y, 0, s, x.length, y.length);  
		return s;
	}
	//TODO compare_arr;
	public static int[][] compare_arr(int[] arr_x, int[] arr_y, int[][] list){
		int[][] arr_tmp = new int[arr_x.length][];
		int len = 0;
		for(int i = 0; i < arr_x.length; i++){
			if(arr_x[i] != arr_y[i]){
				arr_tmp[len] = list[i];
				len++;
			}
		}
		int[][] arr_final = new int[len][];
		System.arraycopy(arr_tmp, 0, arr_final, 0, len);
		return arr_final;
	}
	
	public static int[][] DelTestCase(int[][] arr, int num){
		if(arr.length < num){
			return null;
		}
		shuffle(arr,new Random());
		int[][] newArr = new int[arr.length-num][];
		for(int i=0; i < arr.length-num; i++){
			newArr[i] = arr[i];
		}
		return newArr;
		
	}
	
    // using the random get the random number
    public static  void  shuffle(int[][] array, Random random){
         
        for(int i = array.length; i >= 1; i--){
             
            swap(array,i-1,random.nextInt(i));
        }
    }
     
    // the two number swap  in the array
    public static void swap(int[][] array, int i , int j){
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;   
    }
    public static void printIntArray(int[][]array){
    	for(int i = 0; i < array.length; i++){
    		System.out.println(Arrays.toString(array[i]));
    	}
    }
}
