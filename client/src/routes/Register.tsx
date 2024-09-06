import { Link } from 'react-router-dom';
import { useRef, useState } from 'react';
import Select from 'react-select';

type RoleOption = {
  value: string;
  label: string;
};

const Register = () => {
  const usernameInput = useRef<HTMLInputElement>(null);
  const passwordInput = useRef<HTMLInputElement>(null);
  const [role, setRole] = useState<RoleOption>({ value: '', label: '' });

  function handleSelect(option) {
    setRole(option);
  }

  // function handleSubmit(event: FormEvent<HTMLFormElement>) {
  //   event.preventDefault();
  //   console.log(roleSelect.current.getValue());
  // }

  return (
    <div className='section-min-height mx-auto mb-8 flex max-w-7xl flex-col items-center justify-center gap-4 px-2'>
      <form
        // onSubmit={handleSubmit}
        className='relative flex w-1/2 flex-col items-center justify-evenly gap-8 rounded-2xl border px-20 py-24 text-xl text-primary shadow-2xl'
      >
        <h1 className='text-4xl font-bold text-primary'>Create An Account</h1>
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
        {/* <Button>Button</Button> */}
        <fieldset className='flex w-full flex-col'>
          <label htmlFor='role' className='px-4 py-2'>
            Role
          </label>
          <Select
            isSearchable={false}
            value={role}
            onChange={handleSelect}
            options={[
              { value: 'USER', label: 'Student' },
              { value: 'INSTRUCTOR', label: 'Instructor' },
            ]}
            theme={theme => ({
              ...theme,
              colors: {
                ...theme.colors,
                primary25: '#FEECF4',
                primary: '#F652A0',
              },
            })}
            styles={{
              control: base => ({
                ...base,
                padding: '4px 8px',
              }),
            }}
          />
        </fieldset>
        <div className='mt-4 w-full text-center'>
          <button className='mb-8 w-full rounded-lg border-2 border-primary px-4 py-2 font-semibold hover:bg-primary hover:text-slate-50'>
            Create Account
          </button>
          <p className='text-base'>
            Already Have An Account?{' '}
            <Link to='/login' className='text-slate-500 hover:text-primary'>
              Sign in
            </Link>
          </p>
        </div>
      </form>
    </div>
  );
};

export default Register;
