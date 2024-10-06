

export const initialState = { count: 0 };

// export function countReducer(state, action) {

//     switch (action.type) {
//         case 'increment':
//             return { count: state.count + 1 };
//         case 'decrement':
//             return { count: state.count - 1 };
//         default:
//             throw new Error();
//     }

// }

export function countReducer(state, action) {

    switch (action.type) {
        case 'increment':
            if (action.payload)
                return { count: state.count + action.payload };
            else
                return { count: state.count + 1 };
        case 'decrement':
            if (action.payload)
                return { count: state.count - action.payload };
            else
                return { count: state.count - 1 };
        default:
            throw new Error();
    }

}