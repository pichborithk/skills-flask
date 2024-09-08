import { FormEvent, useRef } from 'react';
import { IoMdExit } from 'react-icons/io';
import { useAppSelector } from '../app/hooks';
import { useCreateSectionMutation } from '../app/services';

type CreateSectionModalProps = {
  close: () => void;
  courseId: number;
  updateCourse: () => void;
};

const CreateSectionModal = ({
  close,
  courseId,
  updateCourse,
}: CreateSectionModalProps) => {
  const { token } = useAppSelector(state => state.auth);
  const sequenceInput = useRef<HTMLInputElement>(null);
  const titleInput = useRef<HTMLInputElement>(null);
  const [createSection, { isLoading }] = useCreateSectionMutation();

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    const sequence = sequenceInput.current!.valueAsNumber;
    const title = titleInput.current!.value;

    await createSection({ token, sequence, title, courseId });

    sequenceInput.current!.valueAsNumber = 0;
    titleInput.current!.value = '';

    updateCourse();
  }

  return (
    <>
      <div className='fixed bottom-0 left-0 right-0 top-0 bg-slate-500 bg-opacity-50'>
        <div className='fixed left-1/2 top-1/2 flex w-1/3 -translate-x-1/2 -translate-y-1/2 flex-col rounded-md bg-slate-50 p-8'>
          <IoMdExit
            onClick={close}
            className='self-end text-primary hover:scale-125 hover:cursor-pointer'
            size={32}
          />
          <form
            onSubmit={handleSubmit}
            className='relative flex flex-col items-center justify-evenly gap-8 px-12 py-16 text-xl text-primary'
          >
            <h1 className='text-4xl font-bold text-primary'>Add New Section</h1>
            <fieldset className='flex w-full flex-col'>
              <label htmlFor='username' className='px-4 py-2'>
                Sequence
              </label>
              <input
                autoComplete='off'
                type='number'
                name='sequence'
                placeholder='Enter Sequence'
                ref={sequenceInput}
                required
                className='rounded-md border px-4 py-2 text-slate-500 focus:outline-primary'
              />
            </fieldset>
            <fieldset className='flex w-full flex-col'>
              <label htmlFor='password' className='px-4 py-2'>
                Title
              </label>
              <input
                type='text'
                name='title'
                placeholder='Enter title'
                ref={titleInput}
                required
                className='rounded-md border px-4 py-2 text-slate-500 focus:outline-primary'
              />
            </fieldset>
            <div className='mt-4 w-full text-center'>
              <button
                className='mb-8 w-full rounded-lg border-2 border-primary px-4 py-2 font-semibold hover:bg-primary hover:text-slate-50'
                disabled={isLoading}
              >
                Add
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default CreateSectionModal;
