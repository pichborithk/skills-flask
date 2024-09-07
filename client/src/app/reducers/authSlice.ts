import { createAsyncThunk, createSlice, PayloadAction } from '@reduxjs/toolkit';
import { AuthResponse, UserRequest } from '../../types/user.types';
import { toast } from 'react-hot-toast';

type AuthState = {
  isLoading: boolean;
  token: string;
  //   status: "idle" | "pending" | "succeeded" | "rejected";
};

const initialState: AuthState = {
  isLoading: false,
  token: localStorage.getItem('TOKEN') ?? '',
};

export const register = createAsyncThunk(
  'auth/register',
  async (request: UserRequest): Promise<AuthResponse | void> => {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/register`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(request),
    });

    return await response.json();
  },
);

export const login = createAsyncThunk(
  'auth/login',
  async (request: Partial<UserRequest>): Promise<AuthResponse | void> => {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/login`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(request),
    });

    return await response.json();
  },
);

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    tokenClear(state) {
      localStorage.removeItem('TOKEN');
      toast.success('Logged Out');
      state.token = '';
    },
  },
  extraReducers: builder => {
    builder
      .addCase(register.pending, state => {
        state.isLoading = true;
      })
      .addCase(
        register.fulfilled,
        (state, action: PayloadAction<AuthResponse | void>) => {
          state.isLoading = false;
          if (action.payload) {
            state.token = action.payload.token;
            localStorage.setItem('TOKEN', action.payload.token);
            toast.success('Register new user successful');
          } else {
            localStorage.removeItem('TOKEN');
            toast.error('Something went wrong');
            return initialState;
          }
        },
      )
      .addCase(register.rejected, state => {
        state.isLoading = false;
        state.token = '';
        localStorage.removeItem('TOKEN');
        toast.error('Something went wrong');
      });

    builder
      .addCase(login.pending, state => {
        state.isLoading = true;
      })
      .addCase(
        login.fulfilled,
        (state, action: PayloadAction<AuthResponse | void>) => {
          state.isLoading = false;
          if (action.payload) {
            state.token = action.payload.token;
            localStorage.setItem('TOKEN', action.payload.token);
            toast.success('Login successful');
          } else {
            localStorage.removeItem('TOKEN');
            toast.error('Something went wrong');
            return initialState;
          }
        },
      )
      .addCase(login.rejected, state => {
        state.isLoading = false;
        state.token = '';
        localStorage.removeItem('TOKEN');
        toast.error('Something went wrong');
      });
  },
});

export const authReducer = authSlice.reducer;
export const { tokenClear } = authSlice.actions;
