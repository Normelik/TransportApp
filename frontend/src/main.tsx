import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import AboutPage from './pages/AboutPage';
import ShipmentsPage from './pages/ShipmentsPage';
import ProfilePage from './pages/ProfilePage';
import NotFoundPage from './pages/NotFoundPage.tsx';
import HomePage from './pages/HomePage.tsx';
import LandingPage from './pages/LandingPage.tsx';
import RegistrationForm from './components/Registration/RegistrationForm.tsx';

const privateLinks: string[] = ['About', 'Shipments', 'Profile', 'Register'];
const publicLinks: string[] = ['About', 'Profile', 'Register'];

const router = createBrowserRouter([
  {
    path: '/',
    element: <LandingPage links={publicLinks} />,
    errorElement: <NotFoundPage />,
  },
  {
    path: '/home',
    element: <HomePage links={privateLinks} />,
    errorElement: <NotFoundPage />,
  },
  {
    path: '/about',
    element: <AboutPage links={privateLinks} />,
  },
  {
    path: '/shipments',
    element: <ShipmentsPage links={privateLinks} />,
  },
  {
    path: '/profile',
    element: <ProfilePage links={privateLinks} />,
  },
  {
    path: '/register',
    element: <RegistrationForm />,
  },
]);

const queryClient = new QueryClient();

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router} />
    </QueryClientProvider>
  </StrictMode>
);
