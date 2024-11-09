// Function to perform linear search on an array 
// Time Complexity: O(n) - linear time complexity 
//   In the worst case, the function may need to iterate through the entire array. 
// Space Complexity: O(1) - constant space complexity 
//   The function only uses a constant amount of extra space regardless of the input size. 
 
function linearSearch(arr, target) { 
    for (let i = 0; i < arr.length; i++) { 
      if (arr[i] === target) { 
        return i; 
      } 
    } 
    return -1; 
  } 
   
  // Example usage 
  const arr = [1, 3, 5, 8, 9]; 
   
  // Measure the execution time of linearSearch function 
  console.time("linearSearch"); 
  const index = linearSearch(arr, 5); 
  console.timeEnd("linearSearch"); 
   
  // Output the result 
  console.log("Index:", index); 