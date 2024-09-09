import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import {
  AllCourses,
  CourseBoard,
  Dashboard,
  ErrorPage,
  Login,
  Register,
  SectionBoard,
} from './routes';
import { CoursesTable, Home, ProfileBoard } from './components';
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
        element: <CourseBoard />,
      },
      {
        path: 'sections/:sectionId',
        element: <SectionBoard />,
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
          { path: 'courses', element: <CoursesTable /> },
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
