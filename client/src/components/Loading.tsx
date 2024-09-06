import { CSSProperties } from 'react';
import { ClipLoader } from 'react-spinners';

const override: CSSProperties = {
  display: 'block',
  margin: '0 auto',
  //   borderColor: 'red',
};

const Loading = () => {
  return (
    <div className='section-min-height mx-auto flex max-w-7xl items-center justify-between gap-8 py-40'>
      <ClipLoader
        color='#F652A0'
        loading={true}
        cssOverride={override}
        size={80}
        aria-label='Loading Spinner'
        data-testid='loader'
        speedMultiplier={0.5}
      />
    </div>
  );
};

export default Loading;
