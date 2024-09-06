import { configureStore } from '@reduxjs/toolkit';
import { setupListeners } from '@reduxjs/toolkit/query';

import { courseSlice, userSlice } from './services';
import { authReducer } from './reducers';

const store = configureStore({
  reducer: {
    auth: authReducer,
    [courseSlice.reducerPath]: courseSlice.reducer,
    [userSlice.reducerPath]: userSlice.reducer,
  },
  middleware: getDefaultMiddleware =>
    getDefaultMiddleware()
      .concat(courseSlice.middleware)
      .concat(userSlice.middleware),
});

setupListeners(store.dispatch);

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export default store;
