import { Outlet } from 'react-router-dom';
import { Footer, Navbar, Notification, ScrollToTop } from './components';

const App = () => {
  return (
    <>
      <Navbar />
      <Outlet />
      <ScrollToTop />
      <Notification />
      <Footer />
    </>
  );
};

export default App;
