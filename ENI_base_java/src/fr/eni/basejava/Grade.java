package fr.eni.basejava;

public class Grade {

	public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
	    int average;
	    int countGrades;
	    int sumGrades;
	    boolean result;
	    sumGrades = 0;
	    countGrades = 0;
	  
	    for(int i = 0 ; i < classPoints.length - 1; i++) {
	      sumGrades = sumGrades + classPoints[i];
	      countGrades = countGrades + 1;
	    }
	    sumGrades = sumGrades + yourPoints;
	    countGrades = countGrades + 1;
	    average = sumGrades / countGrades;
	    
	    return result = (average <= yourPoints) ? true : false;
	 
	  }
	  //test
	  public static void main(String[] args) {
		  
		  System.out.println(betterThanAverage(new int[] {2, 3}, 5));
			
		}
}
