function selectionSort(array) {
    let n=array.length;

    for (let i = 0; i <n ; i++) {

        let maxValueIndex = 0;

        for (let j = 0; j < n - i; j++) {

            if (array[j] > array[maxValueIndex])
                maxValueIndex = j;
        };

        [ array[maxValueIndex], array[n -1- i] ] = [ array[n - 1 - i], array[maxValueIndex] ];

    }

}

const unsortedArray = [5, 2, 4,17, 1, 3]; 
console.log("Before Sorting");
console.log(unsortedArray);
selectionSort(unsortedArray);
console.log("AFTER selectionSort Sorting");
console.log(unsortedArray);