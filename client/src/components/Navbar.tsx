import { Link } from 'react-router-dom';

import logo from '../assets/images/Skills_Lab.png';

const Navbar = () => {
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
          <div className='flex items-center gap-8'>
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
          </div>
        </nav>
      </section>
    </header>
  );
};

export default Navbar;
