import { Link, useNavigate } from 'react-router-dom';
import { FaUserCircle } from 'react-icons/fa';

import logo from '../assets/images/Skills_Lab.png';
import { useAppDispatch, useAppSelector } from '../app/hooks';
import { tokenClear } from '../app/reducers';
import { useState } from 'react';

const Navbar = () => {
  const { token } = useAppSelector(state => state.auth);
  const [isOpen, setIsOpen] = useState(false);
  const dispatch = useAppDispatch();
  const navigate = useNavigate();

  function handleLogout() {
    dispatch(tokenClear());
    setIsOpen(false);
    navigate('/');
  }

  return (
    <header className='absolute top-0 w-full bg-slate-50 shadow-sm'>
      <section className='mx-auto flex max-w-7xl items-center py-2'>
        <Link to='/'>
          <img src={logo} alt='logo web site' className='max-h-24' />
        </Link>
        <nav className='relative flex grow items-center justify-between gap-6 px-8 pt-4 text-xl font-thin text-primary'>
          <div>
            <Link
              to='/courses'
              className='border-b-4 border-transparent px-2 hover:border-secondary'
            >
              Our Classes
            </Link>
          </div>
          <div className='relative flex items-center gap-8'>
            {!token && (
              <>
                <Link
                  to='/login'
                  className='border-b-4 border-transparent px-2 hover:border-secondary'
                >
                  Sign In
                </Link>
                <Link
                  to='/register'
                  className='rounded-md border-2 border-primary bg-primary px-8 py-1 text-slate-50 hover:bg-slate-50 hover:text-primary'
                >
                  Become a Member
                </Link>
              </>
            )}
            {token && (
              <FaUserCircle
                size={40}
                color='hotpink'
                onClick={() => setIsOpen(!isOpen)}
              />
            )}
            {token && isOpen && (
              <ul className='text-md absolute right-0 top-10 rounded-md bg-primary bg-opacity-50 text-slate-50 [&>*]:px-4 [&>*]:py-2 hover:[&>*]:cursor-pointer hover:[&>*]:bg-primary'>
                <li className='rounded-t-md' onClick={() => setIsOpen(false)}>
                  <Link to='/dashboard'>Dashboard</Link>
                </li>
                <li>Setting</li>
                <li onClick={handleLogout} className='rounded-b-md'>
                  Sign Out
                </li>
              </ul>
            )}
          </div>
        </nav>
      </section>
    </header>
  );
};

export default Navbar;
