function maxSubArraySum(arr) {

    //Base case
    if (arr.length === 0) return 0; // If the array is empty, return 0 

    let maxCurrent = arr[0]; // Initialize maxCurrent with the first element 
    let maxGlobal = arr[0];  // Initialize maxGlobal with the first element 

    for (let i = 1; i < arr.length; i++) { 

        maxCurrent = Math.max(maxCurrent + arr[i],  arr[i]);
        
        if(maxCurrent > maxGlobal)
            maxGlobal = maxCurrent;
    }

    return maxGlobal;// Return the maximum subarray sum 
}

const array = [-2, 1, -3, 4, -1, 2, 1, -5, 4]; 
console.log(maxSubArraySum(array)); // Output will be the maximum subarray sum  