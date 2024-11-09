function findMissingNumber(arr) {
    const n = arr.length + 1; // Calculate n (since one number is missing in the array) 
    const expectedSum = (n * (n + 1)) / 2; // Sum of first n natural numbers 

    let actualSum = 0; // Initialize sum of array elements 

    for (let i = 0; i < arr.length; i++) {
        actualSum += arr[i]; // Add each element to the sum 
    }

    return expectedSum - actualSum; // The missing number is the difference between  expected and actual sums 
} 


const array = [1, 2, 4, 6, 3, 7, 8]; 

console.log(findMissingNumber(array)); // Output will be the missing number  