import { Link } from 'react-router-dom';
import { useRef } from 'react';

const Login = () => {
  const usernameInput = useRef<HTMLInputElement>(null);
  const passwordInput = useRef<HTMLInputElement>(null);

  // useEffect(() => {
  //   if (token) {
  //     localStorage.setItem('TOKEN', token);
  //     setRoute('home');
  //     navigate('/');
  //     return;
  //   }
  // }, [token]);

  // useEffect(() => {
  //   setRoute('login');
  // }, []);

  // async function handleSubmit(event: FormEvent<HTMLFormElement>) {
  //   event.preventDefault();

  //   try {
  //     const result = await userLogin(username, password);
  //     if (result.error) {
  //       toast.error(result.message);
  //       return;
  //     }

  //     if (result.token) {
  //       setToken(result.token);
  //       localStorage.setItem('TOKEN', result.token);
  //       setRoute('home');
  //       navigate('/');
  //       toast.success('Logged In');
  //     }
  //   } catch (error) {
  //     console.error(error);
  //   } finally {
  //     setUsername('');
  //     setPassword('');
  //   }
  // }

  return (
    <div className='section-min-height mx-auto mb-8 flex max-w-7xl flex-col items-center justify-center gap-4 px-2'>
      <form
        // onSubmit={handleSubmit}
        className='relative flex w-1/2 flex-col items-center justify-evenly gap-8 rounded-2xl border px-20 py-24 text-xl text-primary shadow-2xl'
      >
        <h1 className='text-4xl font-bold text-primary'>Sign In</h1>
        <fieldset className='flex w-full flex-col'>
          <label htmlFor='username' className='px-4 py-2'>
            Username
          </label>
          <input
            autoComplete='off'
            type='text'
            name='username'
            placeholder='Enter Username'
            ref={usernameInput}
            required
            className='rounded-md border px-4 py-2 text-slate-500 focus:outline-primary'
          />
        </fieldset>
        <fieldset className='flex w-full flex-col'>
          <label htmlFor='password' className='px-4 py-2'>
            Password
          </label>
          <input
            type='password'
            name='password'
            placeholder='Enter Password'
            ref={passwordInput}
            required
            className='rounded-md border px-4 py-2 text-slate-500 focus:outline-primary'
          />
        </fieldset>
        <div className='mt-4 w-full text-center'>
          <button className='mb-8 w-full rounded-lg border-2 border-primary px-4 py-2 font-semibold hover:bg-primary hover:text-slate-50'>
            Sign In
          </button>
          <p className='text-base'>
            Don't have an account?{' '}
            <Link to='/register' className='text-slate-500 hover:text-primary'>
              Join Us
            </Link>
          </p>
        </div>
      </form>
    </div>
  );
};

export default Login;
