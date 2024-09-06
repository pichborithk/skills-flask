const Footer = () => {
  return (
    <footer className='bg-primary shadow-full text-white'>
      <div className='mx-auto flex max-w-7xl flex-row justify-between py-8'>
        <div className='w-1/4'>
          <h1 className='pb-4 text-xl font-semibold'>Skills Lab Academy</h1>
          <p className='text-sm'>The Best Education You Will Ever Try.</p>
        </div>
        <div className='text-right'>
          <h1 className='pb-4 pt-5 text-xl font-medium md:pt-0'>Contact Us</h1>
          <nav className='flex flex-col gap-2'>
            <a
              className='hover:text-brightColor cursor-pointer transition-all'
              href='/'
            >
              skillslab@academy.dev
            </a>
            <a
              className='hover:text-brightColor cursor-pointer transition-all'
              href='/'
            >
              +9990009090
            </a>
            <a
              className='hover:text-brightColor cursor-pointer transition-all'
              href='/'
            >
              Social Media
            </a>
          </nav>
        </div>
      </div>
      <div>
        <p className='py-4 text-center'>
          @copyright developed by
          <span className='text-brightColor'> Pichborith </span> | All rights
          reserved
        </p>
      </div>
    </footer>
  );
};

export default Footer;
