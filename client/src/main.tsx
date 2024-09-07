import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import {
  AllCourses,
  Course,
  Dashboard,
  ErrorPage,
  Login,
  Register,
  Section,
} from './routes';
import { CoursesBoard, Home, ProfileBoard } from './components';
import { Provider } from 'react-redux';
import store from './app/store';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: 'courses',
        element: <AllCourses />,
      },
      {
        path: 'courses/:courseId',
        element: <Course />,
      },
      {
        path: 'sections/:sectionId',
        element: <Section />,
      },
      {
        path: 'login',
        element: <Login />,
      },
      {
        path: 'register',
        element: <Register />,
      },
      {
        path: 'dashboard',
        element: <Dashboard />,
        children: [
          { index: true, element: <ProfileBoard /> },
          { path: 'courses', element: <CoursesBoard /> },
        ],
      },
    ],
  },
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <Provider store={store}>
      <RouterProvider router={router} />
    </Provider>
  </StrictMode>,
);
